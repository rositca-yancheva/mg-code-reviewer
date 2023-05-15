package com.sumup.mgcodereviewer.api.dto;

import com.sumup.mgcodereviewer.model.CardinalDirection;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DroneCardinalDirectionDto {
    @NotNull
    private CardinalDirection cardinalDirection;
}
