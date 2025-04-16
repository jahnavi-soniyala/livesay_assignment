package com.liveasy.Assignment.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facility {

    @NotBlank(message = "Loading point is required")
    private String loadingPoint;
    @NotBlank(message = "Unloading point is required")
    private String unloadingPoint;
    @NotNull(message = "Loading date is required")
    private LocalDateTime loadingDate;
    @NotNull(message = "unloading date is required")
    private LocalDateTime unloadingDate;

}
