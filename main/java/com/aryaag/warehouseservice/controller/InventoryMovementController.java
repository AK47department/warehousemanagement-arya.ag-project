package com.aryaag.warehouseservice.controller;

import com.aryaag.warehouseservice.model.InventoryMovement;
import com.aryaag.warehouseservice.service.InventoryMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryMovementController {

    private final InventoryMovementService inventoryMovementService;

    @GetMapping
    public ResponseEntity<List<InventoryMovement>> getAllMovements() {
        return ResponseEntity.ok(inventoryMovementService.getAllMovements());
    }

    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<InventoryMovement>> getMovementsByWarehouseId(@PathVariable Long warehouseId) {
        return ResponseEntity.ok(inventoryMovementService.getMovementsByWarehouseId(warehouseId));
    }

    @GetMapping("/commodity/{commodityId}")
    public ResponseEntity<List<InventoryMovement>> getMovementsByCommodityId(@PathVariable Long commodityId) {
        return ResponseEntity.ok(inventoryMovementService.getMovementsByCommodityId(commodityId));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<InventoryMovement>> getMovementsByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(inventoryMovementService.getMovementsByCustomerId(customerId));
    }

    @PostMapping("/warehouse/{warehouseId}/commodity/{commodityId}/customer/{customerId}")
    public ResponseEntity<InventoryMovement> addMovement(
            @PathVariable Long warehouseId,
            @PathVariable Long commodityId,
            @PathVariable Long customerId,
            @RequestBody InventoryMovement movement) {
        return ResponseEntity.ok(inventoryMovementService.addMovement(warehouseId, commodityId, customerId, movement));
    }
}
