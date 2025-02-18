package com.aryaag.warehouseservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contactDetails;

    @Column(nullable = false)
    private String contractDetails;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference // Manages reference to break cycle with Commodity
    private List<Commodity> commodities;

    private LocalDateTime createdOn = LocalDateTime.now();
    private LocalDateTime lastUpdatedOn = LocalDateTime.now();
}
