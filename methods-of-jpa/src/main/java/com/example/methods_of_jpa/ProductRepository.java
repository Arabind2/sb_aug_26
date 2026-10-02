package com.example.methods_of_jpa;

import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer>{
    Optional<Product>  findByProductName(String name);

    List<Product> findAllByProductPriceBetween(double startingPrice, double endPrice);

    List<Product> findAllByProductPriceGreaterThanEqual(double price, Sort sort);

    Optional<Product> findByProductNameAndProductBrand(String name, String brand);

    //JPQL--> ------------------java Persistence Query Language---------------->

    // @Query ("SELECT p FROM Product p  WHERE p.productName=?1 AND p.productBrand=?2")   //positional parameter
    // Optional<Product>  getProduct(String name,String brand);

    //   @Query ("SELECT p FROM Product p  WHERE p.productName=:name AND p.productBrand=:brand")   //named parameter
    // Optional<Product>  getProduct(String name,String brand);

    //----------------------------raw sql(native sql) ------------------
// @Query (nativeQuery = true, value = "SELECT * from product WHERE product_name=? AND product_brand=?")
// Optional<Product> getProduct(String name, String brand);

    @Modifying 
    @Transactional //:- either using any DML query or performing multiple DB operations 
    @Query (nativeQuery = true,value = "UPDATE product SET product_Price=:price WHERE product_id=:id")
    int updatePrice(int id, double price);
}
