package com.example.demo1.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomePage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Aloe_Vera_B;

    @FXML
    private ImageView Apple_B;

    @FXML
    private ImageView Avacado_B;

    @FXML
    private ImageView Coca_Cola_B;

    @FXML
    public Label Home_Out;

    @FXML
    public ScrollPane Home_Drink;

    @FXML
    public Label Home_NotSelect_Drink;

    @FXML
    public Label Home_NotSelect_Pizza;

    @FXML
    public ScrollPane Home_Pizza;

    @FXML
    public Label Home_Select_Drink;

    @FXML
    public Label Home_Select_Pizza;

    @FXML
    private ImageView Mango_B;

    @FXML
    private ImageView Pepsi_B;

    @FXML
    private ImageView Pineapple_B;

    @FXML
    private ImageView Pizza_10_B;

    @FXML
    private ImageView Pizza_11_B;

    @FXML
    private ImageView Pizza_12_B;

    @FXML
    private ImageView Pizza_1_B;

    @FXML
    private ImageView Pizza_2_B;

    @FXML
    private TreeView<String> Pizza_10_Tree;

    @FXML
    private TreeView<String> Pizza_11_Tree;

    @FXML
    private TreeView<String> Pizza_12_Tree;

    @FXML
    private TreeView<String> Pizza_1_Tree;

    @FXML
    private TreeView<String> Pizza_2_Tree;

    @FXML
    private TreeView<String> Pizza_3_Tree;

    @FXML
    private TreeView<String> Pizza_4_Tree;

    @FXML
    private TreeView<String> Pizza_5_Tree;

    @FXML
    private TreeView<String> Pizza_6_Tree;

    @FXML
    private TreeView<String> Pizza_7_Tree;

    @FXML
    private TreeView<String> Pizza_8_Tree;

    @FXML
    private TreeView<String> Pizza_9_Tree;

    @FXML
    private ImageView Pizza_3_B;

    @FXML
    private ImageView Pizza_4_B;

    @FXML
    private ImageView Pizza_5_B;

    @FXML
    private ImageView Pizza_6_B;

    @FXML
    private ImageView Pizza_7_B_click;

    @FXML
    private ImageView Pizza_8_B_click;

    @FXML
    private ImageView Pizza_9_B_click;

    @FXML
    private ImageView Strawberry_B;

    @FXML
    private ImageView Up_B;

    @FXML
    private SplitMenuButton Home_Menu;

    @FXML
    private ImageView Watermelon_B;

    @FXML
    private ImageView Wood_Apple_B;

    @FXML
    private ImageView Close_B;

    @FXML
    private ImageView Close_B_10;

    @FXML
    private ImageView Close_B_11;

    @FXML
    private ImageView Close_B_12;

    @FXML
    private ImageView Close_B_2;

    @FXML
    private ImageView Close_B_3;

    @FXML
    private ImageView Close_B_4;

    @FXML
    private ImageView Close_B_5;

    @FXML
    private ImageView Close_B_6;

    @FXML
    private ImageView Close_B_7;

    @FXML
    private ImageView Close_B_8;

    @FXML
    private ImageView Close_B_9;

    @FXML
    private ImageView Drink_Close_B_1;

    @FXML
    private ImageView Drink_Close_B_10;

    @FXML
    private ImageView Drink_Close_B_11;

    @FXML
    private ImageView Drink_Close_B_2;

    @FXML
    private ImageView Drink_Close_B_3;

    @FXML
    private ImageView Drink_Close_B_4;

    @FXML
    private ImageView Drink_Close_B_5;

    @FXML
    private ImageView Drink_Close_B_6;

    @FXML
    private ImageView Drink_Close_B_7;

    @FXML
    private ImageView Drink_Close_B_8;

    @FXML
    private ImageView Drink_Close_B_9;

    @FXML
    private TreeView<String> Drink_10_Tree;

    @FXML
    private TreeView<String> Drink_11_Tree;

    @FXML
    private TreeView<String> Drink_1_Tree;

    @FXML
    private TreeView<String> Drink_2_Tree;

    @FXML
    private TreeView<String> Drink_3_Tree;

    @FXML
    private TreeView<String> Drink_4_Tree;

    @FXML
    private TreeView<String> Drink_5_Tree;

    @FXML
    private TreeView<String> Drink_6_Tree;

    @FXML
    private TreeView<String> Drink_7_Tree;

    @FXML
    private TreeView<String> Drink_8_Tree;

    @FXML
    private TreeView<String> Drink_9_Tree;

    @FXML
    private MenuItem Menu_About_B;

    @FXML
    private MenuItem Menu_Cart_B;

    @FXML
    private MenuItem Menu_Logout_B;

    @FXML
    private MenuItem Menu_History_B;

    @FXML
    private ListView<String> Cart_Bill_List;

    @FXML
    private Label Cart_Lable_Amount;

    @FXML
    private Label Cart_Lable_Discount;

    @FXML
    private Label Cart_Lable_Total;

    @FXML
    private ListView<String> Cart_ListView_Drink;

    @FXML
    private ListView<String> Cart_ListView_Pizza;

    @FXML
    public Pane Cart_Pane;

    @FXML
    private Label Cart_Pay_B;

    @FXML
    private ImageView Home_B;

    @FXML
    private Label Cart_out;

    @FXML
    private Label Total_Lable;

    @FXML
    private Label Discount_Lable;

    @FXML
    private Label Amount_Lable;

    @FXML
    private Button Cart_Clear;

    private List<TreeView> pizzaTrees;
    private List<ImageView> closeButtons;

    private void closeAllPizzas() {
        pizzaTrees.forEach(p -> p.setVisible(false));
        closeButtons.forEach(b -> b.setVisible(false));
    }

    @FXML
    void Home_B_Click(MouseEvent event) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/com/example/demo1/Home-Page.fxml"));
            Scene scene = Home_B.getScene();
            scene.setRoot(newRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Menu_History_B_click(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/demo1/OrderView-Page.fxml")
            );
            Stage stage = (Stage) ((MenuItem) event.getSource())
                    .getParentPopup()
                    .getOwnerWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Menu_About_B_click(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/demo1/About-Page.fxml")
            );
            Stage stage = (Stage) ((MenuItem) event.getSource())
                    .getParentPopup()
                    .getOwnerWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Menu_Cart_B_click(ActionEvent event) {
        Home_Drink.setVisible(false);
        Home_Pizza.setVisible(false);

        Home_NotSelect_Drink.setVisible(false);
        Home_NotSelect_Pizza.setVisible(false);
        Home_Select_Pizza.setVisible(false);
        Home_Select_Drink.setVisible(false);

        Cart_Pane.setVisible(true);
        Home_B.setVisible(true);

        if (Cart_Bill_List.getItems().isEmpty()) {
            Cart_Clear.setDisable(true);
            return;
        }
    }

    @FXML
    void Menu_Logout_B_click(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/demo1/Login-Page.fxml")
            );
            Stage stage = (Stage) ((MenuItem) event.getSource())
                    .getParentPopup()
                    .getOwnerWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Close_B_click(MouseEvent event) {
        Pizza_1_Tree.setVisible(false);
        Close_B.setVisible(false);
    }

    @FXML
    void Close_B2_click(MouseEvent event) {
        Pizza_2_Tree.setVisible(false);
        Close_B_2.setVisible(false);
    }

    @FXML
    void Close_B3_click(MouseEvent event) {
        Pizza_3_Tree.setVisible(false);
        Close_B_3.setVisible(false);
    }

    @FXML
    void Close_B4_click(MouseEvent event) {
        Pizza_4_Tree.setVisible(false);
        Close_B_4.setVisible(false);
    }

    @FXML
    void Close_B5_click(MouseEvent event) {
        Pizza_5_Tree.setVisible(false);
        Close_B_5.setVisible(false);
    }

    @FXML
    void Close_B6_click(MouseEvent event) {
        Pizza_6_Tree.setVisible(false);
        Close_B_6.setVisible(false);
    }

    @FXML
    void Close_B7_click(MouseEvent event) {
        Pizza_7_Tree.setVisible(false);
        Close_B_7.setVisible(false);
    }

    @FXML
    void Close_B8_click(MouseEvent event) {
        Pizza_8_Tree.setVisible(false);
        Close_B_8.setVisible(false);
    }

    @FXML
    void Close_B9_click(MouseEvent event) {
        Pizza_9_Tree.setVisible(false);
        Close_B_9.setVisible(false);
    }

    @FXML
    void Close_B10_click(MouseEvent event) {
        Pizza_10_Tree.setVisible(false);
        Close_B_10.setVisible(false);
    }

    @FXML
    void Close_B11_click(MouseEvent event) {
        Pizza_11_Tree.setVisible(false);
        Close_B_11.setVisible(false);
    }

    @FXML
    void Close_B12_click(MouseEvent event) {
        Pizza_12_Tree.setVisible(false);
        Close_B_12.setVisible(false);
    }

    @FXML
    void Home_NotSelect_Drink_Click(MouseEvent event) {
        Home_Select_Drink.setVisible(true);
        Home_NotSelect_Drink.setVisible(false);
        Home_Select_Pizza.setVisible(false);
        Home_NotSelect_Pizza.setVisible(true);
        Home_Pizza.setVisible(false);
        Home_Drink.setVisible(true);
    }

    @FXML
    void Home_NotSelect_Pizza_Click(MouseEvent event) {
        Home_Select_Pizza.setVisible(true);
        Home_NotSelect_Pizza.setVisible(false);
        Home_Select_Drink.setVisible(false);
        Home_NotSelect_Drink.setVisible(true);
        Home_Pizza.setVisible(true);
        Home_Drink.setVisible(false);
    }

    @FXML
    void Pizza_10_B_click(MouseEvent event) {
        closeAllPizzas();
        Pizza_10_Tree.setVisible(true);
        Close_B_10.setVisible(true);

    }

    @FXML
    void Pizza_11_B_click(MouseEvent event) {
        closeAllPizzas();
        Pizza_11_Tree.setVisible(true);
        Close_B_11.setVisible(true);

    }

    @FXML
    void Pizza_12_B_Click(MouseEvent event) {
        closeAllPizzas();
        Pizza_12_Tree.setVisible(true);
        Close_B_12.setVisible(true);

    }

    @FXML
    void Pizza_1_B_click(MouseEvent event) {
        closeAllPizzas();
        Pizza_1_Tree.setVisible(true);
        Close_B.setVisible(true);
    }

    @FXML
    void Pizza_2_B_click(MouseEvent event) {
        closeAllPizzas();
        Pizza_2_Tree.setVisible(true);
        Close_B_2.setVisible(true);
    }

    @FXML
    void Pizza_3_B_click(MouseEvent event) {
        closeAllPizzas();
        Pizza_3_Tree.setVisible(true);
        Close_B_3.setVisible(true);
    }

    @FXML
    void Pizza_4_B_click(MouseEvent event) {
        closeAllPizzas();
        Pizza_4_Tree.setVisible(true);
        Close_B_4.setVisible(true);
    }

    @FXML
    void Pizza_5_B_click(MouseEvent event) {
        closeAllPizzas();
        Pizza_5_Tree.setVisible(true);
        Close_B_5.setVisible(true);
    }

    @FXML
    void Pizza_6_B_click(MouseEvent event) {
        closeAllPizzas();
        Pizza_6_Tree.setVisible(true);
        Close_B_6.setVisible(true);
    }

    @FXML
    void Pizza_7_B_click(MouseEvent event) {
        closeAllPizzas();
        Pizza_7_Tree.setVisible(true);
        Close_B_7.setVisible(true);
    }

    @FXML
    void Pizza_8_B_click(MouseEvent event) {
        closeAllPizzas();
        Pizza_8_Tree.setVisible(true);
        Close_B_8.setVisible(true);
    }

    @FXML
    void Pizza_9_B_click(MouseEvent event) {
        closeAllPizzas();
        Pizza_9_Tree.setVisible(true);
        Close_B_9.setVisible(true);
    }

    @FXML
    void Mango_B_click(MouseEvent event) {
        closeAllPizzas();
        Drink_4_Tree.setVisible(true);
        Drink_Close_B_4.setVisible(true);
    }

    @FXML
    void Pepsi_B_Click(MouseEvent event) {
        closeAllPizzas();
        Drink_5_Tree.setVisible(true);
        Drink_Close_B_5.setVisible(true);
    }

    @FXML
    void Pineapple_B_Click(MouseEvent event) {
        closeAllPizzas();
        Drink_9_Tree.setVisible(true);
        Drink_Close_B_9.setVisible(true);
    }

    @FXML
    void Aloe_Vera_B_Click(MouseEvent event) {
        closeAllPizzas();
        Drink_7_Tree.setVisible(true);
        Drink_Close_B_7.setVisible(true);
    }

    @FXML
    void Apple_B_Click(MouseEvent event) {
        closeAllPizzas();
        Drink_2_Tree.setVisible(true);
        Drink_Close_B_2.setVisible(true);
    }

    @FXML
    void Avacado_B_Click(MouseEvent event) {
        closeAllPizzas();
        Drink_8_Tree.setVisible(true);
        Drink_Close_B_8.setVisible(true);
    }

    @FXML
    void Coca_Cola_B_click(MouseEvent event) {
        closeAllPizzas();
        Drink_3_Tree.setVisible(true);
        Drink_Close_B_3.setVisible(true);
    }

    @FXML
    void Strawberry_B_Click(MouseEvent event) {
        closeAllPizzas();
        Drink_10_Tree.setVisible(true);
        Drink_Close_B_10.setVisible(true);
    }

    @FXML
    void Up_B_click(MouseEvent event) {
        closeAllPizzas();
        Drink_1_Tree.setVisible(true);
        Drink_Close_B_1.setVisible(true);
    }

    @FXML
    void Watermelon_B_Click(MouseEvent event) {
        closeAllPizzas();
        Drink_11_Tree.setVisible(true);
        Drink_Close_B_11.setVisible(true);
    }

    @FXML
    void Wood_Apple_B_Click(MouseEvent event) {
        closeAllPizzas();
        Drink_6_Tree.setVisible(true);
        Drink_Close_B_6.setVisible(true);
    }

    @FXML
    void Drink_Close_B_10_click(MouseEvent event) {
        Drink_Close_B_10.setVisible(false);
        Drink_10_Tree.setVisible(false);
    }

    @FXML
    void Drink_Close_B_11_click(MouseEvent event) {
        Drink_Close_B_11.setVisible(false);
        Drink_11_Tree.setVisible(false);
    }

    @FXML
    void Drink_Close_B_1_click(MouseEvent event) {
        Drink_Close_B_1.setVisible(false);
        Drink_1_Tree.setVisible(false);
    }

    @FXML
    void Drink_Close_B_2_click(MouseEvent event) {
        Drink_Close_B_2.setVisible(false);
        Drink_2_Tree.setVisible(false);
    }

    @FXML
    void Drink_Close_B_3_click(MouseEvent event) {
        Drink_Close_B_3.setVisible(false);
        Drink_3_Tree.setVisible(false);
    }

    @FXML
    void Drink_Close_B_4_click(MouseEvent event) {
        Drink_Close_B_4.setVisible(false);
        Drink_4_Tree.setVisible(false);
    }

    @FXML
    void Drink_Close_B_5_click(MouseEvent event) {
        Drink_Close_B_5.setVisible(false);
        Drink_5_Tree.setVisible(false);
    }

    @FXML
    void Drink_Close_B_6_click(MouseEvent event) {
        Drink_Close_B_6.setVisible(false);
        Drink_6_Tree.setVisible(false);
    }

    @FXML
    void Drink_Close_B_7_click(MouseEvent event) {
        Drink_Close_B_7.setVisible(false);
        Drink_7_Tree.setVisible(false);
    }

    @FXML
    void Drink_Close_B_8_click(MouseEvent event) {
        Drink_Close_B_8.setVisible(false);
        Drink_8_Tree.setVisible(false);
    }

    @FXML
    void Drink_Close_B_9_click(MouseEvent event) {
        Drink_Close_B_9.setVisible(false);
        Drink_9_Tree.setVisible(false);
    }

    @FXML
    void Cart_Clear_Click(MouseEvent event) {
        Total_Lable.setText("LKR 0");
        Discount_Lable.setText("LKR 0");
        Amount_Lable.setText("LKR 0");
        Cart_Bill_List.getItems().clear();
        Cart_ListView_Pizza.getItems().clear();
        Cart_ListView_Drink.getItems().clear();

    }

    @FXML
    void Cart_Pay_B_Click(MouseEvent event) throws IOException {

        if ((Cart_ListView_Pizza.getItems().isEmpty() && Cart_ListView_Drink.getItems().isEmpty()) || Cart_Bill_List.getItems().isEmpty()) {
            Cart_out.setText("Cart is Empty");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo1/Pay-Page.fxml"));
        Parent root = loader.load(); // load the FXML
        PayPage controller = loader.getController();
        controller.setAmount(Amount_Lable.getText());
        Stage stage = (Stage) Cart_Pay_B.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void setupTreeToCart(TreeView<String> tree, ListView<String> list) {
        tree.getSelectionModel().selectedItemProperty().addListener((obs, oldItem, newItem) -> {
            if (newItem == null) return;
            String value = newItem.getValue();
            if (value.contains("Small") || value.contains("Medium") || value.contains("Large")) {
                String item = tree.getRoot().getValue();
                String size = value.contains("Small") ? "Small (250 ml)" : value.contains("Medium") ? "Medium (500 ml)" : "Large (1 L)";
                String price = value.replaceAll("", "");
                list.getItems().add(item + " " + " - LKR " + price);
                updateBillList();
            }
        });
    }

    private void updateBillList() {
        Cart_Bill_List.getItems().clear();
        Cart_Bill_List.getItems().addAll(Cart_ListView_Pizza.getItems());
        Cart_Bill_List.getItems().addAll(Cart_ListView_Drink.getItems());
        calculateBill();
    }

    private void calculateBill() {

        int total = 0;
        double discount = 0;

        for (String item : Cart_Bill_List.getItems()) {
            try {
                String priceOnly = item.replaceAll("[^0-9]", "");
                total += Integer.parseInt(priceOnly);
            } catch (Exception e) {
            }
        }
        if (total > 3500) {
            discount = total * 0.10;
        }

        double amount = total - discount;

        Total_Lable.setText("LKR " + total);
        Discount_Lable.setText("LKR " + (int) discount);
        Amount_Lable.setText("LKR " + (int) amount);
    }

    public String getAmount() {
        return Amount_Lable.getText();
    }


    @FXML
    void initialize() {
        Home_Select_Drink.setVisible(false);
        Home_NotSelect_Pizza.setVisible(false);
        Home_Drink.setVisible(false);
        Home_Pizza.setVisible(true);
        Pizza_1_Tree.setVisible(false);
        Pizza_2_Tree.setVisible(false);
        Pizza_3_Tree.setVisible(false);
        Pizza_4_Tree.setVisible(false);
        Pizza_5_Tree.setVisible(false);
        Pizza_6_Tree.setVisible(false);
        Pizza_7_Tree.setVisible(false);
        Pizza_8_Tree.setVisible(false);
        Pizza_9_Tree.setVisible(false);
        Pizza_10_Tree.setVisible(false);
        Pizza_11_Tree.setVisible(false);
        Pizza_12_Tree.setVisible(false);
        Close_B.setVisible(false);
        Close_B_2.setVisible(false);
        Close_B_3.setVisible(false);
        Close_B_4.setVisible(false);
        Close_B_5.setVisible(false);
        Close_B_6.setVisible(false);
        Close_B_7.setVisible(false);
        Close_B_8.setVisible(false);
        Close_B_9.setVisible(false);
        Close_B_10.setVisible(false);
        Close_B_11.setVisible(false);
        Close_B_12.setVisible(false);
        Drink_10_Tree.setVisible(false);
        Drink_11_Tree.setVisible(false);
        Drink_1_Tree.setVisible(false);
        Drink_2_Tree.setVisible(false);
        Drink_3_Tree.setVisible(false);
        Drink_4_Tree.setVisible(false);
        Drink_5_Tree.setVisible(false);
        Drink_6_Tree.setVisible(false);
        Drink_7_Tree.setVisible(false);
        Drink_8_Tree.setVisible(false);
        Drink_9_Tree.setVisible(false);
        Drink_Close_B_1.setVisible(false);
        Drink_Close_B_2.setVisible(false);
        Drink_Close_B_3.setVisible(false);
        Drink_Close_B_4.setVisible(false);
        Drink_Close_B_5.setVisible(false);
        Drink_Close_B_6.setVisible(false);
        Drink_Close_B_7.setVisible(false);
        Drink_Close_B_8.setVisible(false);
        Drink_Close_B_9.setVisible(false);
        Drink_Close_B_10.setVisible(false);
        Drink_Close_B_11.setVisible(false);
        Cart_Pane.setVisible(false);
        Home_B.setVisible(false);



        TreeItem<String> root = new TreeItem<>("CALZONE PIZZA");
        root.setExpanded(true);
        TreeItem<String> CALZONE_PIZZA_description = new TreeItem<>("Description:");
        CALZONE_PIZZA_description.getChildren().add(new TreeItem<>("• Folded pizza stuffed with cheese and fillings."));
        root.getChildren().add(CALZONE_PIZZA_description);
        TreeItem<String> CALZONE_PIZZA_ingredients = new TreeItem<>("Ingredients:");
        CALZONE_PIZZA_ingredients.getChildren().add(new TreeItem<>("• Dough folded over cheese"));
        CALZONE_PIZZA_ingredients.getChildren().add(new TreeItem<>("• ham"));
        CALZONE_PIZZA_ingredients.getChildren().add(new TreeItem<>("• mushrooms (classic)"));
        root.getChildren().add(CALZONE_PIZZA_ingredients);
        int CALZONE_S = 1900;
        int CALZONE_M = 2700;
        int CALZONE_L = 3500;
        TreeItem<String> CALZONE_PIZZA_prices = new TreeItem<>("Prices (LKR):");
        CALZONE_PIZZA_prices.getChildren().add(new TreeItem<>("• Small: " + CALZONE_S));
        CALZONE_PIZZA_prices.getChildren().add(new TreeItem<>("• Medium: " +  CALZONE_M));
        CALZONE_PIZZA_prices.getChildren().add(new TreeItem<>("• Large: " + CALZONE_L));
        root.getChildren().add(CALZONE_PIZZA_prices);
        Pizza_1_Tree.setRoot(root);


        TreeItem<String> root2 = new TreeItem<>("CAPRESE PIZZA");
        root2.setExpanded(true);
        TreeItem<String> CAPRESE_PIZZA_description = new TreeItem<>("Description:");
        CAPRESE_PIZZA_description.getChildren().add(new TreeItem<>("• Fresh and light — tastes like Caprese salad on a pizza."));
        root2.getChildren().add(CAPRESE_PIZZA_description);
        TreeItem<String> CAPRESE_PIZZA_ingredients = new TreeItem<>("Ingredients:");
        CAPRESE_PIZZA_ingredients.getChildren().add(new TreeItem<>("• Fresh tomato slices"));
        CAPRESE_PIZZA_ingredients.getChildren().add(new TreeItem<>("• mozzarella"));
        CAPRESE_PIZZA_ingredients.getChildren().add(new TreeItem<>("• basil"));
        CAPRESE_PIZZA_ingredients.getChildren().add(new TreeItem<>("olive oil"));
        root2.getChildren().add(CAPRESE_PIZZA_ingredients);
        int CAPRESE_S = 1700;
        int CAPRESE_M = 2500;
        int CAPRESE_L = 3400;
        TreeItem<String> CAPRESE_PIZZA_prices = new TreeItem<>("Prices (LKR):");
        CAPRESE_PIZZA_prices.getChildren().add(new TreeItem<>("• Small: " + CAPRESE_S));
        CAPRESE_PIZZA_prices.getChildren().add(new TreeItem<>("• Medium: " + CAPRESE_M));
        CAPRESE_PIZZA_prices.getChildren().add(new TreeItem<>("• Large: "   + CAPRESE_L));
        root2.getChildren().add(CAPRESE_PIZZA_prices);
        Pizza_2_Tree.setRoot(root2);


        TreeItem<String> root3 = new TreeItem<>("CHICAGO STYLE DEEP DISH");
        root3.setExpanded(true);
        TreeItem<String> CHICAGO_description = new TreeItem<>("Description:");
        CHICAGO_description.getChildren().add(new TreeItem<>("• Deep-dish pizza with thick crust and hearty filling."));
        root3.getChildren().add(CHICAGO_description);
        TreeItem<String> CHICAGO_ingredients = new TreeItem<>("Ingredients:");
        CHICAGO_ingredients.getChildren().add(new TreeItem<>("• Thick dough"));
        CHICAGO_ingredients.getChildren().add(new TreeItem<>("• tomato sauce on top"));
        CHICAGO_ingredients.getChildren().add(new TreeItem<>("• mozzarella"));
        CHICAGO_ingredients.getChildren().add(new TreeItem<>("sausage/pepperoni"));
        root3.getChildren().add(CHICAGO_ingredients);
        int CHICAGO_S = 2400;
        int CHICAGO_M = 3200;
        int CHICAGO_L = 4500;
        TreeItem<String> CHICAGO_prices = new TreeItem<>("Prices (LKR):");
        CHICAGO_prices.getChildren().add(new TreeItem<>("• Small: "  + CHICAGO_S));
        CHICAGO_prices.getChildren().add(new TreeItem<>("• Medium: "  + CHICAGO_M));
        CHICAGO_prices.getChildren().add(new TreeItem<>("• Large: "   + CHICAGO_L));
        root3.getChildren().add(CHICAGO_prices);
        Pizza_3_Tree.setRoot(root3);


        TreeItem<String> root4 = new TreeItem<>("PIZZA MARINARA");
        root4.setExpanded(true);
        TreeItem<String> MARINARA_description = new TreeItem<>("Description:");
        MARINARA_description.getChildren().add(new TreeItem<>("• Light seafood or garlicky herb pizza (Marinara style)."));
        root4.getChildren().add(MARINARA_description);
        TreeItem<String> MARINARA_ingredients = new TreeItem<>("Ingredients:");
        MARINARA_ingredients.getChildren().add(new TreeItem<>("• Tomato sauce"));
        MARINARA_ingredients.getChildren().add(new TreeItem<>("• garlic"));
        MARINARA_ingredients.getChildren().add(new TreeItem<>("• oregano"));
        MARINARA_ingredients.getChildren().add(new TreeItem<>("olive oil (seafood optional)"));
        root4.getChildren().add(MARINARA_ingredients);
        int MARINARA_S = 1600;
        int MARINARA_M = 2300;
        int MARINARA_L = 3000;
        TreeItem<String> MARINARA_prices = new TreeItem<>("Prices (LKR):");
        MARINARA_prices.getChildren().add(new TreeItem<>("• Small: " + MARINARA_S));
        MARINARA_prices.getChildren().add(new TreeItem<>("• Medium: " + MARINARA_M));
        MARINARA_prices.getChildren().add(new TreeItem<>("• Large: " + MARINARA_L));
        root4.getChildren().add(MARINARA_prices);
        Pizza_4_Tree.setRoot(root4);


        TreeItem<String> root5 = new TreeItem<>("PEPPERONI PIZZA");
        root5.setExpanded(true);
        TreeItem<String> PEPPERONI_description = new TreeItem<>("Description:");
        PEPPERONI_description.getChildren().add(new TreeItem<>("• Pepperoni classic — slightly spicy, cheesy, satisfying."));
        root5.getChildren().add(PEPPERONI_description);
        TreeItem<String> PEPPERONI_ingredients = new TreeItem<>("Ingredients:");
        PEPPERONI_ingredients.getChildren().add(new TreeItem<>("• Tomato sauce"));
        PEPPERONI_ingredients.getChildren().add(new TreeItem<>("• mozzarella"));
        PEPPERONI_ingredients.getChildren().add(new TreeItem<>("• pepperoni slices"));
        root5.getChildren().add(PEPPERONI_ingredients);
        int PEPPERONI_S = 1700;
        int PEPPERONI_M = 2200;
        int PEPPERONI_L = 2800;
        TreeItem<String> PEPPERONI_prices = new TreeItem<>("Prices (LKR):");
        PEPPERONI_prices.getChildren().add(new TreeItem<>("• Small: " + PEPPERONI_S));
        PEPPERONI_prices.getChildren().add(new TreeItem<>("• Medium: " + PEPPERONI_M));
        PEPPERONI_prices.getChildren().add(new TreeItem<>("• Large: "  + PEPPERONI_L));
        root5.getChildren().add(PEPPERONI_prices);
        Pizza_5_Tree.setRoot(root5);


        TreeItem<String> root6 = new TreeItem<>("PIZZA BIANCA");
        root6.setExpanded(true);
        TreeItem<String> BIANCA_description = new TreeItem<>("Description:");
        BIANCA_description.getChildren().add(new TreeItem<>("• White pizza without tomato sauce — creamy and aromatic."));
        root6.getChildren().add(BIANCA_description);
        TreeItem<String> BIANCA_ingredients = new TreeItem<>("Ingredients:");
        BIANCA_ingredients.getChildren().add(new TreeItem<>("• ricotta/parmesan"));
        BIANCA_ingredients.getChildren().add(new TreeItem<>("• mozzarella"));
        BIANCA_ingredients.getChildren().add(new TreeItem<>("• garlic"));
        BIANCA_ingredients.getChildren().add(new TreeItem<>("olive oil"));
        BIANCA_ingredients.getChildren().add(new TreeItem<>("herbs"));
        root6.getChildren().add(BIANCA_ingredients);
        int BIANCA_S = 1800;
        int BIANCA_M = 2800;
        int BIANCA_L = 3600;
        TreeItem<String> BIANCA_prices = new TreeItem<>("Prices (LKR):");
        BIANCA_prices.getChildren().add(new TreeItem<>("• Small: " + BIANCA_S));
        BIANCA_prices.getChildren().add(new TreeItem<>("• Medium: "  + BIANCA_M));
        BIANCA_prices.getChildren().add(new TreeItem<>("• Large: "  + BIANCA_L));
        root6.getChildren().add(BIANCA_prices);
        Pizza_6_Tree.setRoot(root6);


        TreeItem<String> root7 = new TreeItem<>("PIZZA BUFALINA");
        root7.setExpanded(true);
        TreeItem<String> BUFALINA_description = new TreeItem<>("Description:");
        BUFALINA_description.getChildren().add(new TreeItem<>("• Light, creamy buffalo mozzarella pizza with fresh greens."));
        root7.getChildren().add(BUFALINA_description);
        TreeItem<String> BUFALINA_ingredients = new TreeItem<>("Ingredients:");
        BUFALINA_ingredients.getChildren().add(new TreeItem<>("• Buffalo mozzarella"));
        BUFALINA_ingredients.getChildren().add(new TreeItem<>("• light tomato base or white base"));
        BUFALINA_ingredients.getChildren().add(new TreeItem<>("• basil"));
        root7.getChildren().add(BUFALINA_ingredients);
        int BUFALINA_S = 1700;
        int BUFALINA_M = 2500;
        int BUFALINA_L = 3400;
        TreeItem<String> BUFALINA_prices = new TreeItem<>("Prices (LKR):");
        BUFALINA_prices.getChildren().add(new TreeItem<>("• Small: " +  BUFALINA_S));
        BUFALINA_prices.getChildren().add(new TreeItem<>("• Medium: " +  BUFALINA_M));
        BUFALINA_prices.getChildren().add(new TreeItem<>("• Large: " +  BUFALINA_L));
        root7.getChildren().add(BUFALINA_prices);
        Pizza_7_Tree.setRoot(root7);


        TreeItem<String> root8 = new TreeItem<>("PIZZA CAKE");
        root8.setExpanded(true);
        TreeItem<String> CAKE_description = new TreeItem<>("Description:");
        CAKE_description.getChildren().add(new TreeItem<>("• Dessert-style or novelty pizza with sweet toppings (creative/chef’s choice)."));
        root8.getChildren().add(CAKE_description);
        TreeItem<String> CAKE_ingredients = new TreeItem<>("Ingredients:");
        CAKE_ingredients.getChildren().add(new TreeItem<>("• Sweet dough base"));
        CAKE_ingredients.getChildren().add(new TreeItem<>("• fruits/berries"));
        CAKE_ingredients.getChildren().add(new TreeItem<>("• chocolate/cinnamon sugar glaze (varies)"));
        root8.getChildren().add(CAKE_ingredients);
        int CAKE_S = 1700;
        int CAKE_M = 2500;
        int CAKE_L = 3400;
        TreeItem<String> CAKE_prices = new TreeItem<>("Prices (LKR):");
        CAKE_prices.getChildren().add(new TreeItem<>("• Small: " +  CAKE_S));
        CAKE_prices.getChildren().add(new TreeItem<>("• Medium: " +  CAKE_M));
        CAKE_prices.getChildren().add(new TreeItem<>("• Large: " +  CAKE_L));
        root8.getChildren().add(CAKE_prices);
        Pizza_8_Tree.setRoot(root8);


        TreeItem<String> root9 = new TreeItem<>("PIZZA GRANDIOSA");
        root9.setExpanded(true);
        TreeItem<String> GRANDIOSA_description = new TreeItem<>("Description:");
        GRANDIOSA_description.getChildren().add(new TreeItem<>("• Rich, loaded pizza with multiple toppings and a hearty flavor."));
        root9.getChildren().add(GRANDIOSA_description);
        TreeItem<String> GRANDIOSA_ingredients = new TreeItem<>("Ingredients:");
        GRANDIOSA_ingredients.getChildren().add(new TreeItem<>("• tomato sauce"));
        GRANDIOSA_ingredients.getChildren().add(new TreeItem<>("• mozzarella"));
        GRANDIOSA_ingredients.getChildren().add(new TreeItem<>("• ham"));
        GRANDIOSA_ingredients.getChildren().add(new TreeItem<>("sausage/peppers (typical grandiosa style)"));
        root9.getChildren().add(GRANDIOSA_ingredients);
        int GRANDIOSA_S = 2000;
        int GRANDIOSA_M = 2900;
        int GRANDIOSA_L = 3800;
        TreeItem<String> GRANDIOSA_prices = new TreeItem<>("Prices (LKR):");
        GRANDIOSA_prices.getChildren().add(new TreeItem<>("• Small: " + GRANDIOSA_S));
        GRANDIOSA_prices.getChildren().add(new TreeItem<>("• Medium: " + GRANDIOSA_M));
        GRANDIOSA_prices.getChildren().add(new TreeItem<>("• Large: "  + GRANDIOSA_L));
        root9.getChildren().add(GRANDIOSA_prices);
        Pizza_9_Tree.setRoot(root9);


        TreeItem<String> root10 = new TreeItem<>("PIZZA MARGHERITA");
        root10.setExpanded(true);
        TreeItem<String> MARGHERITA_description = new TreeItem<>("Description:");
        MARGHERITA_description.getChildren().add(new TreeItem<>("• Classic Neapolitan; fresh basil, tomatoes, and mozzarella."));
        root10.getChildren().add(MARGHERITA_description);
        TreeItem<String> MARGHERITA_ingredients = new TreeItem<>("Ingredients:");
        MARGHERITA_ingredients.getChildren().add(new TreeItem<>("• Tomato sauce"));
        MARGHERITA_ingredients.getChildren().add(new TreeItem<>("• mozzarella"));
        MARGHERITA_ingredients.getChildren().add(new TreeItem<>("• basil"));
        MARGHERITA_ingredients.getChildren().add(new TreeItem<>("olive oil"));
        root10.getChildren().add(MARGHERITA_ingredients);
        int MARGHERITA_S = 1300;
        int MARGHERITA_M = 1700;
        int MARGHERITA_L = 2100;
        TreeItem<String> MARGHERITA_prices = new TreeItem<>("Prices (LKR):");
        MARGHERITA_prices.getChildren().add(new TreeItem<>("• Small: " + MARGHERITA_S));
        MARGHERITA_prices.getChildren().add(new TreeItem<>("• Medium: " + MARGHERITA_M));
        MARGHERITA_prices.getChildren().add(new TreeItem<>("• Large: " + MARGHERITA_L));
        root10.getChildren().add(MARGHERITA_prices);
        Pizza_10_Tree.setRoot(root10);


        TreeItem<String> root11 = new TreeItem<>("PROSCIUTTO E FUNGHI PIZZA");
        root11.setExpanded(true);
        TreeItem<String> PROSCIUTTO_description = new TreeItem<>("Description:");
        PROSCIUTTO_description.getChildren().add(new TreeItem<>("• Elegant Italian pizza with savory ham and earthy mushrooms."));
        root11.getChildren().add(PROSCIUTTO_description);
        TreeItem<String> PROSCIUTTO_ingredients = new TreeItem<>("Ingredients:");
        PROSCIUTTO_ingredients.getChildren().add(new TreeItem<>("• Prosciutto ham"));
        PROSCIUTTO_ingredients.getChildren().add(new TreeItem<>("• mushrooms"));
        PROSCIUTTO_ingredients.getChildren().add(new TreeItem<>("• mozzarella"));
        PROSCIUTTO_ingredients.getChildren().add(new TreeItem<>("tomato sauce"));
        root11.getChildren().add(PROSCIUTTO_ingredients);
        int PROSCIUTTO_S = 2000;
        int PROSCIUTTO_M = 2800;
        int PROSCIUTTO_L = 3600;
        TreeItem<String> PROSCIUTTO_prices = new TreeItem<>("Prices (LKR):");
        PROSCIUTTO_prices.getChildren().add(new TreeItem<>("• Small: " + PROSCIUTTO_S));
        PROSCIUTTO_prices.getChildren().add(new TreeItem<>("• Medium: " + PROSCIUTTO_M));
        PROSCIUTTO_prices.getChildren().add(new TreeItem<>("• Large: " + PROSCIUTTO_L));
        root11.getChildren().add(PROSCIUTTO_prices);
        Pizza_11_Tree.setRoot(root11);


        TreeItem<String> root12 = new TreeItem<>("TOMATO PIE PIZZA");
        root12.setExpanded(true);
        TreeItem<String> TOMATO_description = new TreeItem<>("Description:");
        TOMATO_description.getChildren().add(new TreeItem<>("• Fresh and light — tastes like Caprese salad on a pizza."));
        root12.getChildren().add(TOMATO_description);
        TreeItem<String> TOMATO_ingredients = new TreeItem<>("Ingredients:");
        TOMATO_ingredients.getChildren().add(new TreeItem<>("• Fresh tomato slices"));
        TOMATO_ingredients.getChildren().add(new TreeItem<>("• mozzarella"));
        TOMATO_ingredients.getChildren().add(new TreeItem<>("• basil"));
        TOMATO_ingredients.getChildren().add(new TreeItem<>("olive oil"));
        root12.getChildren().add(TOMATO_ingredients);
        int TOMATO_S = 1700;
        int TOMATO_M = 2500;
        int TOMATO_L = 3400;
        TreeItem<String> TOMATO_prices = new TreeItem<>("Prices (LKR):");
        TOMATO_prices.getChildren().add(new TreeItem<>("• Small: " + TOMATO_S));
        TOMATO_prices.getChildren().add(new TreeItem<>("• Medium: " +  TOMATO_M));
        TOMATO_prices.getChildren().add(new TreeItem<>("• Large: "  + TOMATO_L));
        root12.getChildren().add(TOMATO_prices);
        Pizza_12_Tree.setRoot(root12);





        

        TreeItem<String> root13 = new TreeItem<>("7Up");
        root13.setExpanded(true);
        int Up_S = 120;
        int Up_M = 200;
        int Up_L = 250;
        TreeItem<String> Up_prices = new TreeItem<>("Prices (LKR):");
        Up_prices.getChildren().add(new TreeItem<>("• Small : " + Up_S));
        Up_prices.getChildren().add(new TreeItem<>("• Medium : " +  Up_M));
        Up_prices.getChildren().add(new TreeItem<>("• Large : "  + Up_L));
        root13.getChildren().add(Up_prices);
        Drink_1_Tree.setRoot(root13);

        TreeItem<String> root14 = new TreeItem<>("Apple Juice");
        root14.setExpanded(true);
        int Apple_S = 300;
        int Apple_M = 550;
        int Apple_L = 1000;
        TreeItem<String> Apple_prices = new TreeItem<>("Prices (LKR):");
        Apple_prices.getChildren().add(new TreeItem<>("• Small : " + Apple_S));
        Apple_prices.getChildren().add(new TreeItem<>("• Medium : " + Apple_M));
        Apple_prices.getChildren().add(new TreeItem<>("• Large : "  + Apple_L));
        root14.getChildren().add(Apple_prices);
        Drink_2_Tree.setRoot(root14);

        TreeItem<String> root15 = new TreeItem<>("Coca-Cola");
        root15.setExpanded(true);
        int Coca_S = 120;
        int Coca_M = 200;
        int Coca_L = 250;
        TreeItem<String> Coca_prices = new TreeItem<>("Prices (LKR):");
        Coca_prices.getChildren().add(new TreeItem<>("• Small : " + Coca_S));
        Coca_prices.getChildren().add(new TreeItem<>("• Medium : " + Coca_M));
        Coca_prices.getChildren().add(new TreeItem<>("• Large : "  + Coca_L));
        root15.getChildren().add(Coca_prices);
        Drink_3_Tree.setRoot(root15);

        TreeItem<String> root16 = new TreeItem<>("Mango Juice");
        root16.setExpanded(true);
        int Mango_S = 250;
        int Mango_M = 450;
        int Mango_L = 800;
        TreeItem<String> Mango_prices = new TreeItem<>("Prices (LKR):");
        Mango_prices.getChildren().add(new TreeItem<>("• Small : " + Mango_S));
        Mango_prices.getChildren().add(new TreeItem<>("• Medium : " + Mango_M));
        Mango_prices.getChildren().add(new TreeItem<>("• Large : "  + Mango_L));
        root16.getChildren().add(Mango_prices);
        Drink_4_Tree.setRoot(root16);

        TreeItem<String> root17 = new TreeItem<>("Pepsi");
        root17.setExpanded(true);
        int Pepsi_S = 250;
        int Pepsi_M = 450;
        int Pepsi_L = 800;
        TreeItem<String> Pepsi_prices = new TreeItem<>("Prices (LKR):");
        Pepsi_prices.getChildren().add(new TreeItem<>("• Small : " + Pepsi_S));
        Pepsi_prices.getChildren().add(new TreeItem<>("• Medium : " + Pepsi_M));
        Pepsi_prices.getChildren().add(new TreeItem<>("• Large : "  + Pepsi_L));
        root17.getChildren().add(Pepsi_prices);
        Drink_5_Tree.setRoot(root17);

        TreeItem<String> root18 = new TreeItem<>("Wood Apple Juice");
        root18.setExpanded(true);
        int Wood_S = 280;
        int Wood_M = 500;
        int Wood_L = 900;
        TreeItem<String> Wood_prices = new TreeItem<>("Prices (LKR):");
        Wood_prices.getChildren().add(new TreeItem<>("• Small : " + Wood_S));
        Wood_prices.getChildren().add(new TreeItem<>("• Medium : " + Wood_M));
        Wood_prices.getChildren().add(new TreeItem<>("• Large : "  + Wood_L));
        root18.getChildren().add(Wood_prices);
        Drink_6_Tree.setRoot(root18);

        TreeItem<String> root19 = new TreeItem<>("Aloe Vera Juice");
        root19.setExpanded(true);
        int Aloe_S = 220;
        int Aloe_M = 400;
        int Aloe_L = 750;
        TreeItem<String> Aloe_prices = new TreeItem<>("Prices (LKR):");
        Aloe_prices.getChildren().add(new TreeItem<>("• Small : " + Aloe_S));
        Aloe_prices.getChildren().add(new TreeItem<>("• Medium : " + Aloe_M));
        Aloe_prices.getChildren().add(new TreeItem<>("• Large : "  + Aloe_L));
        root19.getChildren().add(Aloe_prices);
        Drink_7_Tree.setRoot(root19);

        TreeItem<String> root20 = new TreeItem<>("Avocado Juice");
        root20.setExpanded(true);
        int Avocado_S = 350;
        int Avocado_M = 650;
        int Avocado_L = 1250;
        TreeItem<String> Avocado_prices = new TreeItem<>("Prices (LKR):");
        Avocado_prices.getChildren().add(new TreeItem<>("• Small : " + Avocado_S));
        Avocado_prices.getChildren().add(new TreeItem<>("• Medium : " + Avocado_M));
        Avocado_prices.getChildren().add(new TreeItem<>("• Large : "  + Avocado_L));
        root20.getChildren().add(Avocado_prices);
        Drink_8_Tree.setRoot(root20);

        TreeItem<String> root21 = new TreeItem<>("Pineapple Juice");
        root21.setExpanded(true);
        int Pineapple_S = 200;
        int Pineapple_M = 300;
        int Pineapple_L = 700;
        TreeItem<String> Pineapple_prices = new TreeItem<>("Prices (LKR):");
        Pineapple_prices.getChildren().add(new TreeItem<>("• Small : " + Pineapple_S));
        Pineapple_prices.getChildren().add(new TreeItem<>("• Medium : " + Pineapple_M));
        Pineapple_prices.getChildren().add(new TreeItem<>("• Large : "  + Pineapple_L));
        root21.getChildren().add(Pineapple_prices);
        Drink_9_Tree.setRoot(root21);

        TreeItem<String> root22 = new TreeItem<>("Strawberry Juice");
        root22.setExpanded(true);
        int Strawberry_S = 320;
        int Strawberry_M = 600;
        int Strawberry_L = 1100;
        TreeItem<String> Strawberry_prices = new TreeItem<>("Prices (LKR):");
        Strawberry_prices.getChildren().add(new TreeItem<>("• Small : " + Strawberry_S));
        Strawberry_prices.getChildren().add(new TreeItem<>("• Medium : " + Strawberry_M));
        Strawberry_prices.getChildren().add(new TreeItem<>("• Large : "  + Strawberry_L));
        root22.getChildren().add(Strawberry_prices);
        Drink_10_Tree.setRoot(root22);

        TreeItem<String> root23 = new TreeItem<>("Watermelon Juice");
        root23.setExpanded(true);
        int Watermelon_S = 180;
        int Watermelon_M = 320;
        int Watermelon_L = 600;
        TreeItem<String> Watermelon_prices = new TreeItem<>("Prices (LKR):");
        Watermelon_prices.getChildren().add(new TreeItem<>("• Small : " + Watermelon_S));
        Watermelon_prices.getChildren().add(new TreeItem<>("• Medium : " + Watermelon_M));
        Watermelon_prices.getChildren().add(new TreeItem<>("• Large : "  + Watermelon_L));
        root23.getChildren().add(Watermelon_prices);
        Drink_11_Tree.setRoot(root23);



        setupTreeToCart(Pizza_1_Tree, (ListView<String>) Cart_ListView_Pizza);
        setupTreeToCart(Pizza_2_Tree, (ListView<String>) Cart_ListView_Pizza);
        setupTreeToCart(Pizza_3_Tree, (ListView<String>) Cart_ListView_Pizza);
        setupTreeToCart(Pizza_4_Tree, (ListView<String>) Cart_ListView_Pizza);
        setupTreeToCart(Pizza_5_Tree, (ListView<String>) Cart_ListView_Pizza);
        setupTreeToCart(Pizza_6_Tree, (ListView<String>) Cart_ListView_Pizza);
        setupTreeToCart(Pizza_7_Tree, (ListView<String>) Cart_ListView_Pizza);
        setupTreeToCart(Pizza_8_Tree, (ListView<String>) Cart_ListView_Pizza);
        setupTreeToCart(Pizza_9_Tree, (ListView<String>) Cart_ListView_Pizza);
        setupTreeToCart(Pizza_10_Tree, (ListView<String>) Cart_ListView_Pizza);
        setupTreeToCart(Pizza_11_Tree, (ListView<String>) Cart_ListView_Pizza);
        setupTreeToCart(Pizza_12_Tree, (ListView<String>) Cart_ListView_Pizza);


        setupTreeToCart(Drink_1_Tree, (ListView<String>) Cart_ListView_Drink);
        setupTreeToCart(Drink_2_Tree, (ListView<String>) Cart_ListView_Drink);
        setupTreeToCart(Drink_3_Tree, (ListView<String>) Cart_ListView_Drink);
        setupTreeToCart(Drink_4_Tree, (ListView<String>) Cart_ListView_Drink);
        setupTreeToCart(Drink_5_Tree, (ListView<String>) Cart_ListView_Drink);
        setupTreeToCart(Drink_6_Tree, (ListView<String>) Cart_ListView_Drink);
        setupTreeToCart(Drink_7_Tree, (ListView<String>) Cart_ListView_Drink);
        setupTreeToCart(Drink_8_Tree, (ListView<String>) Cart_ListView_Drink);
        setupTreeToCart(Drink_9_Tree, (ListView<String>) Cart_ListView_Drink);
        setupTreeToCart(Drink_10_Tree, (ListView<String>) Cart_ListView_Drink);
        setupTreeToCart(Drink_11_Tree, (ListView<String>) Cart_ListView_Drink);



        pizzaTrees = List.of(Pizza_1_Tree, Pizza_2_Tree, Pizza_3_Tree, Pizza_4_Tree, Pizza_5_Tree, Pizza_6_Tree, Pizza_7_Tree, Pizza_8_Tree, Pizza_9_Tree, Pizza_10_Tree, Pizza_11_Tree, Pizza_12_Tree,
                Drink_1_Tree, Drink_2_Tree, Drink_3_Tree, Drink_4_Tree, Drink_5_Tree, Drink_6_Tree, Drink_7_Tree, Drink_8_Tree, Drink_9_Tree, Drink_10_Tree, Drink_11_Tree);

        closeButtons = List.of(Close_B, Close_B_2, Close_B_3, Close_B_4, Close_B_5, Close_B_6, Close_B_7, Close_B_8, Close_B_9, Close_B_10, Close_B_11, Close_B_12,
                Drink_Close_B_1, Drink_Close_B_2, Drink_Close_B_3, Drink_Close_B_4, Drink_Close_B_5, Drink_Close_B_6, Drink_Close_B_7, Drink_Close_B_8, Drink_Close_B_9, Drink_Close_B_10, Drink_Close_B_11);
    }

}
