package edu.cst438.sprint3.model;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "Product")
public class Product {
    @Id
    @ApiModelProperty(required = false, hidden = true)
    private String id;
    private String name;
    private String description;
    private String imageURL;
    private Double price = 0.00;
    private Integer stock = 0;

    public Product(String id, String name, String description, String imageURL, Double price, Integer stock) {
        this.id = id; 
        this.setName(name);
        this.setDescription(description);
        this.setImageURL(imageURL);
        this.setPrice(price);
        this.setStock(stock);
    }
    public Product(){}

    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }
}

