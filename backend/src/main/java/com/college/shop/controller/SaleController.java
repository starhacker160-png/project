package com.college.shop.controller;

import com.college.shop.model.*;
import com.college.shop.repository.*;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@RestController @RequestMapping("/api/sales") @CrossOrigin(origins={"${FRONTEND_URL:http://localhost:5173}", "http://127.0.0.1:5173"})
public class SaleController {
    private final SaleRepository sales; private final ProductRepository products;
    public SaleController(SaleRepository sales, ProductRepository products){this.sales=sales;this.products=products;}
    @GetMapping public List<Sale> all(){return sales.findAll();}
    @PostMapping @Transactional public ResponseEntity<?> create(@RequestBody Sale sale){
        if(sale.getItems()==null || sale.getItems().isEmpty()) return ResponseEntity.badRequest().body("Cart is empty");
        BigDecimal total=BigDecimal.ZERO;
        for(SaleItem item: sale.getItems()){
            Product p=products.findById(item.getProductId()).orElseThrow(() -> new IllegalArgumentException("Product not found"));
            if(p.getStock()<item.getQuantity()) return ResponseEntity.badRequest().body(p.getName()+" has insufficient stock");
            p.setStock(p.getStock()-item.getQuantity()); products.save(p);
            item.setProductName(p.getName()); item.setPrice(p.getPrice()); item.setSubtotal(p.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            total=total.add(item.getSubtotal());
        }
        sale.setId(null); sale.setSaleDate(LocalDateTime.now()); sale.setTotal(total);
        return ResponseEntity.status(HttpStatus.CREATED).body(sales.save(sale));
    }
}
