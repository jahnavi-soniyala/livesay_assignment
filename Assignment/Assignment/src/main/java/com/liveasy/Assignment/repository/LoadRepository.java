package com.liveasy.Assignment.repository;

import com.liveasy.Assignment.models.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoadRepository extends JpaRepository<Load, UUID> {
    List<Load> findByShipperId(String shipperId);

    List<Load> findByTruckType(String truckType);
}
