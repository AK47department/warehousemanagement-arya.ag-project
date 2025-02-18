package com.aryaag.warehouseservice.repository;

import com.aryaag.warehouseservice.model.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommodityRepository extends JpaRepository<Commodity, Long> {
    List<Commodity> findByWarehouseId(Long warehouseId);
    Optional<Commodity> findByIdAndWarehouseId(Long commodityId, Long warehouseId);
}
