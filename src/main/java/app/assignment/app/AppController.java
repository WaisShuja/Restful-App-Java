package app.assignment.app;

import app.assignment.app.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(name = "/api/v1")
@Component
//@Service

public class AppController {

    @Autowired
    private ProductService productService;

    /**
     *
     * @param brand
     * @param priceRange for products' price ex: 20 - 2000
     * @param sortBy by either price, date or
     * @param page
     * @param size
     * @return
     *       * @param minPrice from lowest number
     *      * @param maxPrice  to highest number
     *      * @param brand   with the brand name
     *      * @param page index starting from {@literal 0}
     *      * @param size number of items
     *      * @return  list of the products filtered by price range and brand
     */
    @RequestMapping(name = "/api/products", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getProducts(@RequestParam (required = false, defaultValue = "") String brand,
                                      @RequestParam (required = false, defaultValue = "") String priceRange,
                                      @RequestParam (required = false, defaultValue = "") String sortBy,
                                      @RequestParam (defaultValue = "0") int page,
                                      @RequestParam (defaultValue = "7") int size){


        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts(brand, priceRange, sortBy, page, size));
    }

}
