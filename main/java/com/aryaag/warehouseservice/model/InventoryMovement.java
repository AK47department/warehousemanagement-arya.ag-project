package com.aryaag.warehouseservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class InventoryMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String movementType; // INWARD or OUTWARD

    @Column(nullable = false)
    private Integer quantity;

    private LocalDateTime movementDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "commodity_id", nullable = false)
    @JsonManagedReference
    private Commodity commodity;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonManagedReference
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    @JsonBackReference
    private Warehouse warehouse;
}
