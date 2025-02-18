package com.aryaag.warehouseservice.controller;

import com.aryaag.warehouseservice.model.Commodity;
import com.aryaag.warehouseservice.service.CommodityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/warehouses")
@RequiredArgsConstructor
public class CommodityController {

    private final CommodityService commodityService;

    // Get all commodities for a specific warehouse
    @GetMapping("/{warehouseId}/commodities")
    public ResponseEntity<List<Commodity>> getAllCommodities(@PathVariable Long warehouseId) {
        return ResponseEntity.ok(commodityService.getAllCommoditiesByWarehouseId(warehouseId));
    }

    // Get a specific commodity under a specific warehouse
    @GetMapping("/{warehouseId}/commodities/{commodityId}")
    public ResponseEntity<Commodity> getCommodityById(
            @PathVariable Long warehouseId,
            @PathVariable Long commodityId) {
        return commodityService.getCommodityByIdAndWarehouseId(commodityId, warehouseId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new commodity under a specific warehouse
    @PostMapping("/{warehouseId}/commodities")
    public ResponseEntity<Commodity> addCommodity(
            @PathVariable Long warehouseId,
            @RequestBody Commodity commodity) {
        return ResponseEntity.ok(commodityService.addCommodity(warehouseId, commodity));
    }

    // Update an existing commodity under a specific warehouse
    @PutMapping("/{warehouseId}/commodities/{commodityId}")
    public ResponseEntity<Commodity> updateCommodity(
            @PathVariable Long warehouseId,
            @PathVariable Long commodityId,
            @RequestBody Commodity commodity
    ) {
        return ResponseEntity.ok(commodityService.updateCommodity(warehouseId, commodityId, commodity));
    }

    // Delete a commodity under a specific warehouse
    @DeleteMapping("/{warehouseId}/commodities/{commodityId}")
    public ResponseEntity<Void> deleteCommodity(
            @PathVariable Long warehouseId,
            @PathVariable Long commodityId) {
        commodityService.deleteCommodity(warehouseId, commodityId);
        return ResponseEntity.noContent().build();
    }
}
