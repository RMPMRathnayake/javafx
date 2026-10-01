package com.example.demo1.Models;

import javafx.beans.property.SimpleStringProperty;

public class Order {

    private final SimpleStringProperty items;
    private final SimpleStringProperty amount;
    private final SimpleStringProperty payment;
    private final SimpleStringProperty date;

    public Order(String items, String amount, String payment, String date) {
        this.items = new SimpleStringProperty(items);
        this.amount = new SimpleStringProperty(amount);
        this.payment = new SimpleStringProperty(payment);
        this.date = new SimpleStringProperty(date);
    }

    public String getItems() {
        return items.get();
    }

    public String getAmount() {
        return amount.get();
    }

    public String getPayment() {
        return payment.get();
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty itemsProperty() { return items; }
    public SimpleStringProperty amountProperty() { return amount; }
    public SimpleStringProperty paymentProperty() { return payment; }
    public SimpleStringProperty dateProperty() { return date; }
}
