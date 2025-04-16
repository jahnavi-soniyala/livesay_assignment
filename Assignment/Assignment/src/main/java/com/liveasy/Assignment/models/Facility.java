package com.liveasy.Assignment.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facility {

    private String loadingPoint;
    private String unloadingPoint;
    private LocalDateTime loadingDate;  // Use LocalDateTime to match Timestamp
    private LocalDateTime unloadingDate;  // Use LocalDateTime to match Timestamp

}
