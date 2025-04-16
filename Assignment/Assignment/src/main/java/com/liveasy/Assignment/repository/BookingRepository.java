package com.liveasy.Assignment.repository;

import com.liveasy.Assignment.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {
    List<Booking> findByTransporterId(String transporterId);

    List<Booking> findByLoadId(UUID loadId);
}

