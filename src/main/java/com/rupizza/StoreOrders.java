package com.rupizza;

import java.util.ArrayList;

/**
 * A class that represents the entire order history of the store.
 * Provides options to add orders, remove orders, and holds the next order available.
 * @author Karthik Gangireddy, Vineal Sunkara
 */
public class StoreOrders {
    private ArrayList<Order> orderList; //arraylist with every order in the store's history
    private int nextOrder; //next available order

    /**
     * Default constructor for the Store orders.
     */
    public StoreOrders () {
        this.orderList = new ArrayList<Order>();
        this.nextOrder = 1;
    }

    /**
     * Adds an order to the order list.
     * @param o order to add.
     */
    public void addOrder (Order o) {
        orderList.add(o);
    }

    /**
     * removes order from the order list.
     * @param index index of the order to remove.
     */
    public void removeOrder (int index) {this.orderList.remove(index);
    }

    /**
     * Increments and gets the next available order.
     * @return the number of the next available order.
     */
    public int getNextOrder() {
        this.nextOrder = this.orderList.size();
        return this.nextOrder;
    }

    /**
     * Gets the number of total orders the store has had.
     * @return size of the order list array list.
     */
    public int getNumOrders () {
        return this.orderList.size();
    }

    /**
     * Gets an order from a given index.
     * @param index index of the desired order.
     * @return the order.
     */
    public Order getOrder (int index) {
        return this.orderList.get(index);
    }
}
