package com.college.shop.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SaleItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private Long productId;
    private String productName;
    private Integer quantity;
    @Column(precision=10, scale=2) private BigDecimal price;
    @Column(precision=12, scale=2) private BigDecimal subtotal;
}
