package edu.cst438.sprint3.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cart {
    private String id;

    Map<String,Integer> productsInCart;

    public Cart(String id) {
        this.id = id;
        this.productsInCart = new HashMap<>();
    }

    public void addToCart(String productId, int quantity){
        int current = productsInCart.getOrDefault(productId, 0);
        productsInCart.put(id, current + quantity);
    }
}

