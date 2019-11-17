package edu.cst438.sprint3.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import edu.cst438.sprint3.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query (value = "{'id':?0}") 
    User findByUserId(String id);

    @Query (value = "{'email':?0}")  
	User findByUserName(String email);
}
