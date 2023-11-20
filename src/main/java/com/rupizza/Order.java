package com.rupizza;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class Order {
    protected float orderNumber;
    protected ArrayList<Pizza> orderItems;

    public Order () {
        this.orderNumber = 0;
        this.orderItems = new ArrayList<Pizza>();
    }

    public float getOrderNumber () {
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

    public ArrayList<String> printList () {
        ArrayList<String> view = new ArrayList<String>();
        for (int i = 0; i < orderItems.size(); i++) {
            view.add(this.orderItems.get(i).toString());
        }
        return view;
    }

}
