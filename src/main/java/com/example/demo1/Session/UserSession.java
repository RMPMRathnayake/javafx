package com.example.demo1.Session;

import java.util.ArrayList;
import java.util.List;

public class UserSession {

    private static String username;
    private static List<String> cartItems = new ArrayList<>();

    public static void setUsername(String user) {
        username = user;
    }

    public static String getUsername() {
        return username;
    }

    public static void addCartItem(String item) {
        cartItems.add(item);
    }

    public static List<String> getCartItems() {
        return cartItems;
    }

    public static void clear() {
        username = null;
        cartItems.clear();
    }

}
