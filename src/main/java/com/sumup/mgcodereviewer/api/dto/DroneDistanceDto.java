package com.sumup.mgcodereviewer.api.dto;

import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class DroneDistanceDto {
    private @Min(1) int distance;
}
