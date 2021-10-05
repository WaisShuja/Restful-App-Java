package app.assignment.controller;

import app.assignment.app.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api/v1")

public class AppController {

    @RequestMapping(name = "products", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> getProducts(Product products){
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

}
