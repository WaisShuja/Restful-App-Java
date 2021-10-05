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
@Service

public class AppController {

    @Autowired
    private ProductService productService;

    @RequestMapping(name = "products", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getProducts(@RequestParam (required = false) String brand,
                                      @RequestParam (required = false) String priceRange){
        if (brand == null) brand = "";
        if (priceRange == null) priceRange = "";

        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts(brand,priceRange));
    }

}
