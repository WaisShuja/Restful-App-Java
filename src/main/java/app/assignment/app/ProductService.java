package app.assignment.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductService {

     @Autowired
     private ProductRepository productRepository;
     private List<Product> products = new ArrayList<>();


     public List<Product> getProducts(String brand,String priceRange, String sortBy,int page, int size) {

         System.out.println("Brand: " + brand + " Price Range: " + priceRange);

//        Default return
         if (brand.isEmpty() && priceRange.isEmpty()) {
             products = getAllProducts(page, size);
         } // ReturnByName
        else if(!brand.isEmpty() && priceRange.isEmpty()) {
//         Filter By Brand
             products = productRepository.findByBrand(brand);

         }else if(brand.isEmpty() && !priceRange.isEmpty()){
//            Filter by Price Range
            float minPrice = Float.valueOf(priceRange.split("\\-", -1)[0]);
             float maxPrice = Float.valueOf(priceRange.split("\\-", -1)[1]);
            minPrice = Math.min(minPrice,maxPrice);
            maxPrice = Math.max(maxPrice,minPrice);

            if(minPrice < 0 || maxPrice < 0){
                throw new Error("Price cannot be less than 0 !");
            }
            products = getProductsByPriceRange(minPrice, maxPrice, page, size);
             System.out.println("Price Range: " + priceRange + " Brand : " + brand);
         } else {
             /**
              * Filter by Brand and PriceRange
              */
            double minPrice = Double.valueOf(priceRange.split("\\-", -1)[0]);
            double maxPrice = Double.valueOf(priceRange.split("\\-",-1)[1]);
            minPrice = Math.min(minPrice,maxPrice);
            maxPrice = Math.max(maxPrice, minPrice);
            if (minPrice < 0 || maxPrice < 0){
                throw new Error("Price cannot be less than 0");
            }
            products = getProductsByPriceRangeAndBrand(minPrice,maxPrice,brand, page, size);
         }

         if(!sortBy.isEmpty()) {
             sortProducts(sortBy);
         }
         return products;
     }




    private List<Product> getAllProducts(int page, int size){
        Page<Product> productPage = productRepository.findAll(PageRequest.of(page,size,Sort.by(Sort.Direction.DESC,"creationDate")));
        List<Product> products = productPage.getContent();
        return products;
    }

     public List<Product> getProductsByPriceRange(double minPrice, double maxPrice,int page, int size) {
         return getAllProducts(page, size).stream().filter(prod ->  prod.getPrice() > minPrice).
                 filter(prod ->  prod.getPrice() < maxPrice).collect(Collectors.toList());
     }

    /**
     *
      * @param minPrice from lowest number
     * @param maxPrice  to highest number
     * @param brand   with the brand name
     * @param page index starting from {@literal 0}
     * @param size number of items
     * @return  list of the products filtered by price range and brand
     */
     private List<Product> getProductsByPriceRangeAndBrand(double minPrice, double maxPrice, String brand, int page, int size){
         return productRepository.findByBrand(brand).stream()
                 .filter(product -> product.getPrice() > minPrice)
                 .filter((product -> product.getPrice() <= maxPrice))
                 .collect(Collectors.toList());
         /*getAllProducts(page, size).stream()
                 .filter(brd -> brd.getBrand().equals(brand))
                 .filter(prd -> prd.getPrice() > minPrice ).
                 filter(prd ->  prd.getPrice() < maxPrice).collect(Collectors.toList());*/

     }




    private void sortProducts(String sortBy) {
        switch (sortBy) {
            case "name":
                Collections.sort(products, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                break;

            case "price":
                Collections.sort(products, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return Double.compare(o1.getPrice(), o2.getPrice());
                    }
                });
                break;

            case "date":
                Collections.sort(products, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getCreationDate().compareTo(o2.getCreationDate());
                    }
                });
                break;
            default:
                break;
        }
    }

}
