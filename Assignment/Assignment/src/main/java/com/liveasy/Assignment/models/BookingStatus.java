package com.liveasy.Assignment.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

public enum BookingStatus {
    PENDING, ACCEPTED, REJECTED;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Booking {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;

        // This field represents the ID of the Load associated with the Booking
        private UUID loadId; // Make sure this is present

        private String transporterId;
        private double proposedRate;
        private String comment;

        @Enumerated(EnumType.STRING)
        private BookingStatus status = PENDING;

        private LocalDateTime requestedAt;
    }
}
