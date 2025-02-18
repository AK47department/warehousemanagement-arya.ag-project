package com.aryaag.warehouseservice.controller;

import com.aryaag.warehouseservice.model.Warehouse;
import com.aryaag.warehouseservice.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/warehouses")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    // Add Warehouse
    @PostMapping
    public ResponseEntity<String> addWarehouse(@RequestBody Warehouse warehouse) {
        // Validate UID format: Alphanumeric
        if (warehouse.getUid() == null || !warehouse.getUid().matches("^[a-zA-Z0-9]+$")) {
            return ResponseEntity.badRequest().body("Invalid UID format. Only alphanumeric characters allowed.");
        }

        // Check for duplicate UID
        if (warehouseService.existsByUid(warehouse.getUid())) {
            return ResponseEntity.badRequest().body("Warehouse with the same UID already exists.");
        }

        warehouseService.addWarehouse(warehouse);
        return ResponseEntity.ok("Warehouse added successfully.");
    }

    // Get All Warehouses
    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        return ResponseEntity.ok(warehouseService.getAllWarehouses());
    }

    // Delete Warehouse by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWarehouse(@PathVariable Long id) {
        if (warehouseService.deleteWarehouse(id)) {
            return ResponseEntity.ok("Warehouse deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id, @RequestBody Warehouse warehouseDetails) {
        Warehouse updatedWarehouse = warehouseService.updateWarehouse(id, warehouseDetails);
        return ResponseEntity.ok(updatedWarehouse);
    }

}
