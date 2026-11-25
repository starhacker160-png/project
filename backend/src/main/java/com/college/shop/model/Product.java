package com.college.shop.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String name;
    private String category;
    @Column(precision=10, scale=2, nullable=false) private BigDecimal price;
    private Integer stock = 0;
}
