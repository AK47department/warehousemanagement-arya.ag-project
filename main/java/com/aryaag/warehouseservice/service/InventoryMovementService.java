package com.aryaag.warehouseservice.service;

import com.aryaag.warehouseservice.model.Commodity;
import com.aryaag.warehouseservice.model.Customer;
import com.aryaag.warehouseservice.model.InventoryMovement;
import com.aryaag.warehouseservice.model.Warehouse;
import com.aryaag.warehouseservice.repository.CommodityRepository;
import com.aryaag.warehouseservice.repository.CustomerRepository;
import com.aryaag.warehouseservice.repository.InventoryMovementRepository;
import com.aryaag.warehouseservice.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryMovementService {

    private final InventoryMovementRepository inventoryMovementRepository;
    private final WarehouseRepository warehouseRepository;
    private final CommodityRepository commodityRepository;
    private final CustomerRepository customerRepository;

    // Get all movements
    public List<InventoryMovement> getAllMovements() {
        return inventoryMovementRepository.findAll();
    }

    // Get movements by warehouse
    public List<InventoryMovement> getMovementsByWarehouseId(Long warehouseId) {
        return inventoryMovementRepository.findByWarehouseId(warehouseId);
    }

    // Get movements by commodity
    public List<InventoryMovement> getMovementsByCommodityId(Long commodityId) {
        return inventoryMovementRepository.findByCommodityId(commodityId);
    }

    // Get movements by customer
    public List<InventoryMovement> getMovementsByCustomerId(Long customerId) {
        return inventoryMovementRepository.findByCustomerId(customerId);
    }

    // Add a new inventory movement
    public InventoryMovement addMovement(Long warehouseId, Long commodityId, Long customerId, InventoryMovement movement) {
        Warehouse warehouse = warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new RuntimeException("Warehouse not found with ID: " + warehouseId));
        Commodity commodity = commodityRepository.findById(commodityId)
                .orElseThrow(() -> new RuntimeException("Commodity not found with ID: " + commodityId));
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        movement.setWarehouse(warehouse);
        movement.setCommodity(commodity);
        movement.setCustomer(customer);

        return inventoryMovementRepository.save(movement);
    }
}
