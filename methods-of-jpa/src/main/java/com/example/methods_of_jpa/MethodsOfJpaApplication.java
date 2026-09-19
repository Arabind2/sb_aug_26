
package com.example.methods_of_jpa;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.RequiredArgsConstructor;

@SpringBootApplication

@RequiredArgsConstructor 

public class MethodsOfJpaApplication {

    private final ProductRepository productRepository;
    private final OrdersService ordersService;
    public static void main(String[] args) {

        SpringApplication.run(MethodsOfJpaApplication.class, args);

    }

    @Bean

    public CommandLineRunner commandLineRunner(){

        return  args->{

            // Product product=Product.builder()

            // .productName("Iphone 17 pro max")

            // .productBrand("Apple")

            // .productPrice(180000-99)

            // .build();

            //save-----
            // Product savedProduct=productRepository.save(product);
            // System.out.println("saved product is:- "+savedProduct);

            //saveAll-------
           //  productRepository.saveAll(getProducts());

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

           //  productRepository.deleteById(5);

             //Delete All -------
            // List<Product> products=productRepository.findAll(Sort.by(Direction.DESC, "productPrice"));
        //  productRepository.deleteAll();
              // products.forEach(System.out::println);

            //   Product existingProduct2=productRepository.findById(52).orElseThrow();
            //         existingProduct2.setProductBrand("NOKIA");
            //         productRepository.save(existingProduct2);

           // Page<Product> products=productRepository.findAll(PageRequest.of(0,5, Direction.DESC, "productId"));
         //   System.out.println("Page information is : "+products);
            //pagenumber -> 0 based indexing
            //pagesize -> number of data inside the page
           // products.forEach(System.out::println);

        //  Optional<Product> optionalGalaxy=  productRepository.findByProductName("Galaxy S25");
        //  System.out.println(optionalGalaxy.orElseThrow());

     //  productRepository.findAllByProductPriceBetween(1000, 10000).forEach(System.out::println);;

    // productRepository.findAllByProductPriceGreaterThanEqual(5000,Sort.by(Direction.ASC, "productPrice")).forEach(System.out::println);

//   Product find1= productRepository.findByProductNameAndProductBrand("iPhone 17","Apple").orElseThrow();
//             System.out.println(find1);
  
//----------------------------
//      Optional<Product> result = productRepository.getProduct("product - 1", "NOKIA");
// result.ifPresent(System.out::println);

// int affectRow=productRepository.updatePrice(52, 1000);
// System.out.println("No of affected rows : "+affectRow);

ordersService.placeOrder(52, 9);

        };

    }

    // private List<Product> getProducts(){
    //   return  IntStream.range(1,10).mapToObj(i -> Product.builder()
    //         .productName("product - "+i)
    //         .productBrand("brand- "+i)
    //         .productPrice(1000*i)
    //         .build())
            
    //         .toList();
    // }



}

