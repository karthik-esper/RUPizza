package com.rupizza;
import javafx.collections.FXCollections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class Order {
    private int orderNumber;
    private ArrayList<Pizza> orderItems;

    public Order () {
        this.orderNumber = 1;
        this.orderItems = new ArrayList<Pizza>();
    }

    public int getOrderNumber () {
        return this.orderNumber;
    }

    public ArrayList<Pizza> getOrderItems () {
        return this.orderItems;
    }

    public void addToOrder (Pizza p) {
        int count = 0;
        for (Pizza item : orderItems) {
            count++;
        }
        orderItems.add(count,p);
    }

    public void incrementOrder () {
        this.orderNumber++;
    }

    public ArrayList<String> printList () {
        ArrayList<String> view = new ArrayList<String>();
        for (int i = 0; i < orderItems.size(); i++) {
            view.add(this.orderItems.get(i).toString());
        }
        return view;
    }

    public void removeItem (int index) {
        orderItems.remove(index);
    }

    public int getSize () {
        return orderItems.size();
    }

    public double getPrice (int index) {
        return orderItems.get(index).price();
    }

    public void clearOrder () {
        this.orderItems = new ArrayList<Pizza>();
    }

    public double orderPrice () {
        double price = 0;
        for (int i = 0; i < orderItems.size(); i++) {
                price += orderItems.get(i).price();
            }
        return price;
        }

}
