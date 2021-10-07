package app.assignment.app;

import app.assignment.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api/v1")
@Component
public class AppController {

    @Autowired
    private ProductService productService;

    /**
     * @param brand filter by Brand
     * @param priceRange for products' price ex: 20 - 2000
     * @param sortBy by either price, date or
     * @param page index starting from {@literal 0}
     * @param size number of items
     * @return Find and display the list of Products by Brand, PriceRange, SortBy, Page and Size in the Response Body
     */
    @RequestMapping(name = "products", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getProducts(@RequestParam (required = false, defaultValue = "") String brand,
                                      @RequestParam (required = false, defaultValue = "") String priceRange,
                                      @RequestParam (required = false, defaultValue = "") String sortBy,
                                      @RequestParam (defaultValue = "0") int page,
                                      @RequestParam (defaultValue = "7") int size){


        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts(brand, priceRange, sortBy, page, size));
    }

}
