package com.example.demo1.Database;

import com.example.demo1.Models.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBHelper {

    private static final String DB_URL = "jdbc:sqlite:demo1.db";

    // ------------------ CONNECT ------------------
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // ------------------ CREATE TABLE ------------------
    public static void createUsersTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    first_name TEXT NOT NULL,
                    last_name TEXT NOT NULL,
                    username TEXT UNIQUE NOT NULL,
                    email TEXT UNIQUE NOT NULL,
                    password TEXT NOT NULL
                );
                """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ------------------ CREATE ORDERS TABLE ------------------
    public static void createOrdersTable() {
        String sql = """
        CREATE TABLE IF NOT EXISTS orders (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            username TEXT NOT NULL,
            name TEXT NOT NULL,
            telephone TEXT NOT NULL,
            address TEXT NOT NULL,
            city TEXT NOT NULL,
            payment_method TEXT NOT NULL,
            amount TEXT NOT NULL,
            order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        );
        """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // ------------------ REGISTER USER ------------------
    public static boolean registerUser(String firstName, String lastName,
                                       String username, String email, String password) {

        String checkSql = "SELECT * FROM users WHERE username = ? OR email = ?";
        String insertSql = """
                INSERT INTO users (first_name, last_name, username, email, password)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection conn = connect()) {

            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, username);
            checkStmt.setString(2, email);

            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                return false; // username or email exists
            }

            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setString(1, firstName);
            insertStmt.setString(2, lastName);
            insertStmt.setString(3, username);
            insertStmt.setString(4, email);
            insertStmt.setString(5, password); // (later you can hash)

            insertStmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ------------------ LOGIN USER ------------------
    public static boolean loginUser(String username, String password) {

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true if user exists

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ------------------ CHECK EMAIL EXISTS ------------------
    public static boolean emailExists(String email) {
        String sql = "SELECT 1 FROM users WHERE email = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            return stmt.executeQuery().next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ------------------ UPDATE PASSWORD ------------------
    public static boolean updatePassword(String email, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE email = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newPassword);
            stmt.setString(2, email);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // ------------------ SAVE ORDER ------------------
    public static boolean saveOrder(
            String username,
            String name,
            String tp,
            String address,
            String city,
            String paymentMethod,
            String amount
    ) {
        String sql = """
        INSERT INTO orders
        (username, name, telephone, address, city, payment_method, amount)
        VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, name);
            stmt.setString(3, tp);
            stmt.setString(4, address);
            stmt.setString(5, city);
            stmt.setString(6, paymentMethod);
            stmt.setString(7, amount);

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ObservableList<Order> getOrdersByUser(String username) {
        ObservableList<Order> orders = FXCollections.observableArrayList();
        String sql = "SELECT * FROM orders WHERE username = ? ORDER BY order_date DESC";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String items = rs.getString("name");
                String amount = rs.getString("amount");
                String payment = rs.getString("payment_method");
                String date = rs.getString("order_date");

                orders.add(new Order(items, amount, payment, date));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
}
