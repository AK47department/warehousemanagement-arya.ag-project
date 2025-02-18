package com.aryaag.warehouseservice.service;

import com.aryaag.warehouseservice.model.Commodity;
import com.aryaag.warehouseservice.model.Customer;
import com.aryaag.warehouseservice.model.Warehouse;
import com.aryaag.warehouseservice.repository.CommodityRepository;
import com.aryaag.warehouseservice.repository.CustomerRepository;
import com.aryaag.warehouseservice.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommodityService {

    private final CommodityRepository commodityRepository;
    private final WarehouseRepository warehouseRepository;
    private final CustomerRepository customerRepository;

    // Get all commodities for a specific warehouse
    public List<Commodity> getAllCommoditiesByWarehouseId(Long warehouseId) {
        return commodityRepository.findByWarehouseId(warehouseId);
    }

    // Get a particular commodity by ID and Warehouse ID
    public Optional<Commodity> getCommodityByIdAndWarehouseId(Long commodityId, Long warehouseId) {
        return commodityRepository.findByIdAndWarehouseId(commodityId, warehouseId);
    }

    // Add a new commodity under a specific warehouse
    public Commodity addCommodity(Long warehouseId, Commodity commodity) {
        // Fetch the warehouse
        Warehouse warehouse = warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));
        commodity.setWarehouse(warehouse);

        // Fetch the customer and associate it with the commodity (if customerId is provided)
        if (commodity.getCustomer() != null && commodity.getCustomer().getId() != null) {
            Customer customer = customerRepository.findById(commodity.getCustomer().getId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
            commodity.setCustomer(customer);
        }

        return commodityRepository.save(commodity);
    }

    // Update an existing commodity under a specific warehouse
    public Commodity updateCommodity(Long warehouseId, Long commodityId, Commodity updatedCommodity) {
        return commodityRepository.findByIdAndWarehouseId(commodityId, warehouseId)
                .map(existingCommodity -> {
                    existingCommodity.setName(updatedCommodity.getName());
                    existingCommodity.setQuantity(updatedCommodity.getQuantity());
                    existingCommodity.setLastUpdatedOn(LocalDateTime.now());

                    // Update the associated customer (if provided)
                    if (updatedCommodity.getCustomer() != null && updatedCommodity.getCustomer().getId() != null) {
                        Customer customer = customerRepository.findById(updatedCommodity.getCustomer().getId())
                                .orElseThrow(() -> new RuntimeException("Customer not found"));
                        existingCommodity.setCustomer(customer);
                    } else {
                        existingCommodity.setCustomer(null);  // Remove customer association if not provided
                    }

                    return commodityRepository.save(existingCommodity);
                }).orElseThrow(() -> new RuntimeException("Commodity not found"));
    }

    // Delete a commodity under a specific warehouse
    public void deleteCommodity(Long warehouseId, Long commodityId) {
        Commodity commodity = commodityRepository.findByIdAndWarehouseId(commodityId, warehouseId)
                .orElseThrow(() -> new RuntimeException("Commodity not found"));
        commodityRepository.delete(commodity);
    }
}
