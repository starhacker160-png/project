package com.college.shop.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Entity @Getter @Setter @NoArgsConstructor
public class Sale {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String customerName;
    private LocalDateTime saleDate = LocalDateTime.now();
    @Column(precision=12, scale=2) private BigDecimal total;
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true) private List<SaleItem> items = new ArrayList<>();
}
