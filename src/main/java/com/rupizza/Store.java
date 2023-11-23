package com.rupizza;

public class Store {
    private static Store instance = new Store();
    private Order currentOrder;
    private StoreOrders orderHistory;

    private Store () {
        currentOrder = new Order();
        orderHistory = new StoreOrders();
    }

    public static Store getInstance() {
        return instance;
    }

    public Order getCurrentOrder () {
        return currentOrder;
    }

    public void setCurrentOrder (Order o) {
        this.currentOrder = o;
    }

    public void setNextOrder() {
        Order placeholder = new Order();
        placeholder.incrementOrder();
        this.orderHistory.addOrder(placeholder);
        this.currentOrder = placeholder;
    }

    public StoreOrders getOrderHistory() {
        return orderHistory;
    }
}
