package edu.cst438.sprint3.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import edu.cst438.sprint3.model.Cart;


@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    @Query (value = "{'id':?0}")   
    Cart findByCartId(String id);
}