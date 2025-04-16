package com.liveasy.Assignment.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotBlank(message = "Shipper ID is required")
    private String shipperId;

    @Embedded
    @Valid
    private Facility facility;
    @NotBlank(message = "product type is required")
    private String productType;
    @NotBlank(message = "truck type is required")
    private String truckType;
    @Min(value = 1, message = "at least 1 truck is required")
    private int noOfTrucks;
    @Positive(message = "Weight must be a positive number")
    private double weight;
    private String comment;
    private LocalDateTime datePosted;

    @Enumerated(EnumType.STRING)
    private LoadStatus status = LoadStatus.POSTED;


}
