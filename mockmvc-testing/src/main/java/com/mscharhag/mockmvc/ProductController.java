package com.mscharhag.mockmvc;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.CacheControl.noCache;

@RestController
public class ProductController {

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        return ResponseEntity.ok()
                .cacheControl(noCache())
                .body(new Product("Cool Gadget", "Looks cool"));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        // update..
        return ResponseEntity.ok(product);
    }
}
