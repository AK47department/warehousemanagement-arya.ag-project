package com.aryaag.warehouseservice.service;

import com.aryaag.warehouseservice.model.Warehouse;
import com.aryaag.warehouseservice.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public Warehouse addWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public boolean deleteWarehouse(Long id) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(id);
        if (warehouse.isPresent()) {
            warehouseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existsByUid(String uid) {
        return warehouseRepository.existsByUid(uid);
    }

    public Warehouse updateWarehouse(Long id, Warehouse warehouseDetails) {
        Warehouse existingWarehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found with id: " + id));

        existingWarehouse.setName(warehouseDetails.getName());
        existingWarehouse.setLocation(warehouseDetails.getLocation());
        existingWarehouse.setCapacity(warehouseDetails.getCapacity());

        return warehouseRepository.save(existingWarehouse);
    }




}
