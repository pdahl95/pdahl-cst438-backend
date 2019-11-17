package edu.cst438.sprint3.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.cst438.sprint3.model.Cart;
import edu.cst438.sprint3.model.Product;
import edu.cst438.sprint3.model.User;
import edu.cst438.sprint3.repositories.ProductRepository;
import edu.cst438.sprint3.repositories.UserRepository;
import edu.cst438.sprint3.utils.BadRequestException;
import edu.cst438.sprint3.utils.ForbiddenException;
import io.swagger.annotations.ApiOperation;

@RestController
public class CartController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    @ApiOperation(value = "Add products to Users shoppingcart.")
    @PostMapping("Users/addToCart")
    public void add(final String productId, final String username, final String password, final int quantity)
            throws Exception {
        final User user = verifyAndGetUser(username, password);
        verifyProduct(productId);
        final Cart cart = user.getShoppingcart();
        cart.addToCart(productId, quantity);
        userRepository.save(user);
    }

    @ApiOperation(value = "Update the quanity of a product in the shopping cart.")
    @PostMapping("Users/updateRemove")
    public void updateOrRemoveFromCart(final String username, final String password, final String productId,
            final int quantity) throws Exception {
        final User user = verifyAndGetUser(username, password);
        verifyProduct(productId);
        final Cart cart = user.getShoppingcart();
        if (quantity == 0) {
            userRepository.deleteById(productId);
        }
        cart.updateCart(productId, quantity);
        userRepository.save(user);
    }

    @ApiOperation(value = "Checkout the shopping cart for user and update the stock in Product table.")
    @PostMapping("Users/checkout")
    public void checkout(final String username) throws Exception {
        final User user = userRepository.findByUserName(username);
        final Cart cart = user.getShoppingcart();
        // Get list of products
        List<Product> productinProductTable =  productRepository.findAll();
        Map<String,Integer> shoppingCart = user.getShoppingcart().getInCart();
        // check if product is in the cart 
        for(Product prod : productinProductTable){
           if(shoppingCart.containsKey(prod.getId())){
                // subtract quanity from stock 
                int stock = prod.getStock();
                int quanity =  shoppingCart.get(prod.getId());
                int newStock = stock - quanity; 
                prod.setStock(newStock); 
                productRepository.save(prod);
           }
        }
        // delete from shopping cart 
        cart.checkout(); 
        userRepository.save(user);    
    }

    private User verifyAndGetUser(final String username, final String password) throws Exception {
        final User user = userRepository.findByUserName(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new ForbiddenException();
        }
        return user;
    }

    private boolean verifyProduct(final String productId) throws Exception {
        final Product product = productRepository.findByRepoId(productId);
        if(product == null){
            throw new BadRequestException(); 
        }
        return true; 
    }

}