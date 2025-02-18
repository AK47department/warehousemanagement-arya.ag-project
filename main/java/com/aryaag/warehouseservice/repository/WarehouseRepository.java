package com.aryaag.warehouseservice.repository;

import com.aryaag.warehouseservice.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    boolean existsByUid(String uid);
}


