package edu.cst438.sprint3.controller;

// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// import edu.cst438.sprint3.model.User;
// import edu.cst438.sprint3.repositories.ProductRepository;
// import edu.cst438.sprint3.repositories.UserRepository;
// import edu.cst438.sprint3.model.Cart;
// import edu.cst438.sprint3.model.Product;

@RestController
public class CartController {

    // @Autowired
    // private Cart shoppingCart; 
    // private Integer quantity; 
    // public CartController(Product prod, User user, Integer quantity){
    //     prodToCart = new Cart(); 
        

    // }



    // UserRepository userRepository;
    // ProductRepository productRepository;


    // @PostMapping("Cart/addToCart")
    // public ResponseEntity<String> add(String productId,
    //  String userId,
    //   String password,
    //    int quntity) {
    //     // user.authenticate();
    //     User user = userRepository.findByUserId(userId);
    //     if(user==null || !user.getPassword().equals(password)){
    //         new ResponseEntity<>(HttpStatus.FORBIDDEN);
    //     }
    //     Product product = productRepository.findByRepoId(productId);
    //     if(product == null){
    //         new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    //     }
    //     Cart cart = user.getShoppingcart();
    //     if(cart == null){
    //         cart = new Cart(UUID.randomUUID().toString());
    //     }
    //     cart.addToCart(productId, quntity);
    //     user.setShoppingcart(cart);
    //     userRepository.save(user);
    //     return new ResponseEntity<String>(HttpStatus.OK);
    // }
}