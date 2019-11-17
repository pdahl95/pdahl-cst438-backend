package edu.cst438.sprint3.model;
import java.util.Map;
import java.util.HashMap;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cart {
    // Map of Product Id and Quantity of each product 
    private Map<String,Integer> productsInCart;

    public Cart () {
        this.productsInCart = new HashMap<>();
    }

    public Map<String,Integer> getInCart () {
        return this.productsInCart; 
    }

    public void addToCart(String productId, int quantity){
        int current = productsInCart.getOrDefault(productId, 0);
        productsInCart.put(productId, current + quantity);
    }
    public void updateCart(String productId, int quantity){
        productsInCart.getOrDefault(productId, 0);
        productsInCart.put(productId, quantity);
    }
    public void checkout(){
        productsInCart.clear();
    }
}

