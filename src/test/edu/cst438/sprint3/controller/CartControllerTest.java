package edu.cst438.sprint3.controller;

import edu.cst438.sprint3.Sprint3Application;
import edu.cst438.sprint3.repositories.UserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Sprint3Application.class)
@DirtiesContext
public class CartControllerTest {

}
