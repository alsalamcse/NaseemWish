package com.naseem.naseemwish.data;

/**
 * Created by user on 15/11/2017.
 */

public class Product {
    private String name;
    private double price;
    private double amount;
    /**
     * if the product is bought.
     */
    private boolean isCompleted;
    /**
     * the path of product's image.
     */
    private String imgPath;
    /**
     * a special key or ID unique for each product (primary key)
     */
    private String keyId;

    /**
     * building product
     * @param name
     * @param price
     * @param amount
     */
    public Product(String name, double price, double amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        isCompleted=false;
        imgPath=null;
    }

    public Product(String name, double price, double amount, boolean isCompleted, String imgPath, String keyId) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isCompleted = isCompleted;
        this.imgPath = imgPath;
        this.keyId = keyId;
    }

    public Product(){}

}
