package com.notification.enums;

public enum ServiceName {

    ORDER_SERVICE("order-service"),
    INVENTORY_SERVICE("inventory-service"),
    USER_SERVICE("user-service"),
    PAYMENT_SERVICE("payment-service"),
    NOTIFICATION_SERVICE("notification-service");

    private final String value;

    ServiceName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
