package edu.cst438.sprint3.controller;

import edu.cst438.sprint3.Sprint3Application;
import edu.cst438.sprint3.model.User;
import edu.cst438.sprint3.repositories.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import org.junit.jupiter.api.Test;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Sprint3Application.class)
@DirtiesContext
class UserControllerTest {

    @Test
    public void saveUserToDB(@Autowired  UserRepository userRepository){
        userRepository.save( new User( "1", "test@email.com", "testpass" ) );
        User user = userRepository.findByUserId( "1" );
        Assert.assertNotNull( user );
        Assert.assertEquals( user.getPassword(), "testpass" );
    }

    @Test
    public void saveUserWithShoppingCartToDB(@Autowired  UserRepository userRepository){
        User user = new User( "1", "test@email.com", "testpass" );
        user.getShoppingcart().addToCart( "1", 1 );
        userRepository.save( user );
        User loadedUser = userRepository.findByUserId( "1" );
        Assert.assertNotNull( loadedUser );
        int quantity = user.getShoppingcart().getInCart().get( "1" );
        Assert.assertNotNull( quantity );
        Assert.assertEquals( quantity , 1 );
    }


}