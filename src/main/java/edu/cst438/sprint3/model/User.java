package edu.cst438.sprint3.model;
import edu.cst438.sprint3.model.Cart;

import java.util.UUID;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "Users")
public class User {
    @Id
    @ApiModelProperty(required = false, hidden = true)
    private String id;
    private String email;
    private String password;
    private Cart shoppingcart;

    public User(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.shoppingcart = new Cart(UUID.randomUUID().toString());
    }


	public Cart getShoppingcart() {
        return shoppingcart;
    }

    public void setShoppingcart(Cart shoppingcart) {
        this.shoppingcart = shoppingcart;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

  


}

