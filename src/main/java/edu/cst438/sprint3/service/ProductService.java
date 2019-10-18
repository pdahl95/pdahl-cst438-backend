package edu.cst438.sprint3.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.cst438.sprint3.model.Product;
import edu.cst438.sprint3.repositories.ProductRepository;

@Component
public class ProductService implements CommandLineRunner{
    @Autowired
    ProductRepository prodRepo; 
    @Override
    public void run(String... args) throws Exception {
        Product dress = new Product("1","Dress with Tie Belt", "Available", "image", 99.99, 120);
        Product pants = new Product("2","Ankle Length Slacks", "Available", "image", 50.00, 124);
        Product top = new Product("3","Satin Cami Top", "Available", "image", 24.99, 200);

        // delete db data 
        prodRepo.deleteAll();
        //add db seeds
        List<Product> prod = Arrays.asList(dress, pants, top);
        prodRepo.saveAll(prod);
    }

}