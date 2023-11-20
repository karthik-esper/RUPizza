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

    public void setCurrentOrder(Order order) {
        this.currentOrder = order;
    }

    public StoreOrders getOrderHistory() {
        return orderHistory;
    }
}
