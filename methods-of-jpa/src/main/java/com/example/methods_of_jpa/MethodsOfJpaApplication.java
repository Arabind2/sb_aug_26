
package com.example.methods_of_jpa;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;

import lombok.RequiredArgsConstructor;

@SpringBootApplication

@RequiredArgsConstructor 

public class MethodsOfJpaApplication {

    private final ProductRepository productRepository;

    public static void main(String[] args) {

        SpringApplication.run(MethodsOfJpaApplication.class, args);

    }

    @Bean

    public CommandLineRunner commandLineRunner(){

        return  args->{

            Product product=Product.builder()

            .productName("Iphone 17 pro max")

            .productBrand("Apple")

            .productPrice(180000-99)

            .build();

            //save-----
            // Product savedProduct=productRepository.save(product);
            // System.out.println("saved product is:- "+savedProduct);

            //saveAll-------
              productRepository.saveAll(getProducts());

            //COUNT------
                  // long totalProducts=productRepository.count();
            // System.out.println("Total number of products is : "+totalProducts);
      
            //Exists & Exists By Id
            //         boolean isphoneExists=productRepository.existsById(1);
            // System.out.println("is phone 17 exists : "+isphoneExists);
        
            // Product existingProduct=productRepository.findById(1).orElseThrow();
            // boolean iphoneExists2=productRepository.exists(Example.of(existingProduct));
            // System.out.println("is iphone 17 exists 2 :- "+iphoneExists2);

            //delete
            // Product exists=productRepository.findById(2).orElseThrow();
            // productRepository.delete(exists);

             productRepository.deleteById(5);;
        };

    }

    private List<Product> getProducts(){
      return  IntStream.range(1,10).mapToObj(i -> Product.builder()
            .productName("product - "+i)
            .productBrand("brand- "+i)
            .productPrice(1000*i)
            .build())
            
            .toList();
    }

}

