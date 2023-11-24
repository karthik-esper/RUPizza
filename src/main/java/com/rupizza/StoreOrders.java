package com.rupizza;

import java.util.ArrayList;

public class StoreOrders {
    private ArrayList<Order> orderList;
    private int nextOrder;

    public StoreOrders () {
        this.orderList = new ArrayList<Order>();
        this.nextOrder = 1;
    }
    public void addOrder (Order o) {
        orderList.add(o);
    }

    public void removeOrder (int index) {this.orderList.remove(index);
    }

    public int getNextOrder() {
        this.nextOrder = this.orderList.size();
        return this.nextOrder;
    }

    public int getNumOrders () {
        return this.orderList.size();
    }

    public Order getOrder (int index) {
        return this.orderList.get(index);
    }
}
