package com.liveasy.Assignment.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "Load is required")
    @ManyToOne
    @JoinColumn(name = "load_id")
    private Load load;
    @NotBlank(message = "Transporter ID is required")
    private String transporterId;
    @NotNull(message = "Proposed rate is required")
    @Positive(message = "Proposed rate must be a positive number")
    private double proposedRate;
    private String comment;
    private LocalDateTime requestedAt;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private BookingStatus status = BookingStatus.PENDING;
    @PrePersist
    public void setRequestedAt() {
        this.requestedAt = LocalDateTime.now();
    }
}