package com.college.shop.controller;

import com.college.shop.model.Product;
import com.college.shop.repository.ProductRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController @RequestMapping("/api/products") @CrossOrigin(origins={"${FRONTEND_URL:http://localhost:5173}", "http://127.0.0.1:5173"})
public class ProductController {
    private final ProductRepository repo;
    public ProductController(ProductRepository repo){this.repo=repo;}
    @GetMapping public List<Product> all(){ return repo.findAll(); }
    @PostMapping public ResponseEntity<Product> create(@RequestBody Product product){ product.setId(null); return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(product)); }
    @PutMapping("/{id}") public Product update(@PathVariable Long id,@RequestBody Product p){ p.setId(id); return repo.save(p); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){ repo.deleteById(id); return ResponseEntity.noContent().build(); }
}
