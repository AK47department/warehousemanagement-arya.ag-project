package com.aryaag.warehouseservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    @JsonBackReference // Breaks circular reference with Customer
    private Customer customer;

    private LocalDateTime createdOn = LocalDateTime.now();
    private LocalDateTime lastUpdatedOn = LocalDateTime.now();
}
