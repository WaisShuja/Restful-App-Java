package app.assignment.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductService {

     @Autowired
     private ProductRepository productRepository;
     private List<Product> products = new ArrayList<>();


     public List<Product> getProducts(String brand,String priceRange) {
//         ReturnByName
         if (brand.isEmpty() && priceRange.isEmpty()) {
             products = getAllProducts();
         } // ReturnByName
        else if(!brand.isEmpty() && priceRange.isEmpty()) {
//         Filter By Brand
             products = productRepository.findByBrand(brand);
         }else if(brand.isEmpty() && !priceRange.isEmpty()){
            float minPrice = Float.valueOf(priceRange.split("\\-", -1)[0]);
             float maxPrice = Float.valueOf(priceRange.split("\\-", -1)[1]);
            minPrice = Math.min(minPrice,maxPrice);
            maxPrice = Math.max(maxPrice,minPrice);

            if(minPrice < 0 || maxPrice < 0){
                throw new Error("Price cannot be less than 0 !");
            }
            products = getProductsByPriceRange(minPrice, maxPrice);
             System.out.println("Price Range: " + priceRange + "Brand: " + brand);
         }

         return products;

     }

     public List<Product> getProductsByPriceRange(float minPrice, float maxPrice){
         return productRepository.findAll().stream().filter(prd -> prd.getPrice() > minPrice).
                 filter(prd -> prd.getPrice() < maxPrice).
                 collect(Collectors.toList());
     }

     private List<Product> getAllProducts(){
         productRepository.findAll().stream().forEach(product -> {
             products.add(product);
         });
         return productRepository.findAll();
     }

}
