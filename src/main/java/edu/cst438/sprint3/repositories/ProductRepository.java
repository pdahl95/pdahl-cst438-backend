package edu.cst438.sprint3.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import edu.cst438.sprint3.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    @Query (value = "{'id':?0}")   
    Product findByRepoId(String id);
}