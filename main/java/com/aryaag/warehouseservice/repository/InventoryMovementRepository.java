package com.aryaag.warehouseservice.repository;

import com.aryaag.warehouseservice.model.InventoryMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryMovementRepository extends JpaRepository<InventoryMovement, Long> {
    List<InventoryMovement> findByWarehouseId(Long warehouseId);
    List<InventoryMovement> findByCommodityId(Long commodityId);
    List<InventoryMovement> findByCustomerId(Long customerId);
}
