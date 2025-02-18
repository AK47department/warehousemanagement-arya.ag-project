package com.aryaag.warehouseservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    private Integer capacity;

    @Column(nullable = false, unique = true)
    private String uid;  // Alphanumeric Unique Identifier

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdOn = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime lastUpdatedOn = LocalDateTime.now();

    @PreUpdate
    public void onUpdate() {
        this.lastUpdatedOn = LocalDateTime.now();}
}
