package edu.cst438.sprint3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.cst438.sprint3.model.Product;
import edu.cst438.sprint3.repositories.ProductRepository;
import io.swagger.annotations.ApiOperation;

@RestController
public class ProductController {
    @Autowired
    ProductRepository prodRepository;

    @ApiOperation(value = "Get all the products from the Product table.")
    @GetMapping("Product/allProd")
    public List<Product> getAll () {
        List<Product> result = prodRepository.findAll();
        return result;
    }
    @ApiOperation(value = "Add a prodict to the Product table.")
    @PostMapping("/Product/add/")
    public Product newProduct(@RequestBody Product product) {
        return prodRepository.save(product);
    }
    @ApiOperation(value = "Get a product by ID from the Product table.")
    @GetMapping("/Product/get/{id}")
    public Product getProductById(@PathVariable String id){
        Product result = prodRepository.findByRepoId(id);
        return result;
    }
	
}