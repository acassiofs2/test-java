package br.com.blz.testjava.controller;

import br.com.blz.testjava.model.product.Product;
import br.com.blz.testjava.model.product.ProductRequest;
import br.com.blz.testjava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest input) {
        try {
            Product product = productService.createProduct(input);
            return ResponseEntity.created(URI.create("/api/products/" + product.getSku())).body(product);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{sku}")
    public ResponseEntity<?> getBySku(@PathVariable(name = "sku") Integer sku) {
        return ResponseEntity.ok(productService.retrieveProduct(sku));
    }

    @PutMapping("{sku}")
    public ResponseEntity<?> updateBySku(@PathVariable(name = "sku") Integer sku, @RequestBody ProductRequest input) {
        return ResponseEntity.ok(productService.updateProduct(sku, input));
    }

    @GetMapping
    public ResponseEntity<?> listProducts() {
        return ResponseEntity.ok(productService.retrieveAllProducts());
    }

    @DeleteMapping("{sku}")
    public ResponseEntity<?> deleteBySku(@PathVariable(name = "sku") Integer sku) {
        productService.deleteProduct(sku);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

}
