package com.jleber.login.challenge.dsl;


import com.jleber.login.challenge.model.Product;

public class ProductDSL {

    private Product product;

    private ProductDSL(){
        product = new Product();
    }

    public static ProductDSL newProduct(){
        return new ProductDSL();
    }

    public ProductDSL id(Long id){
        product.setIdProduct(id);
        return this;
    }

    public ProductDSL name(String name){
        product.setName(name);
        return this;
    }

    public ProductDSL type(String type){
        product.setType(type);
        return this;
    }

    public Product build(){
        return product;
    }

}
