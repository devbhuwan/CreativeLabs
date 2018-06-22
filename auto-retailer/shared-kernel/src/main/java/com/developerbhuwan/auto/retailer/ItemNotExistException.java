package com.developerbhuwan.auto.retailer;

import lombok.NonNull;

public class ItemNotExistException extends RuntimeException {
    public ItemNotExistException(@NonNull String message) {
        super(message);
    }
}
