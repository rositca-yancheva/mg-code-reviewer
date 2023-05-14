package com.sumup.mgcodereviewer.api;

import com.sumup.mgcodereviewer.api.dto.DroneCardinalDirectionDto;
import com.sumup.mgcodereviewer.api.dto.DroneDistanceDto;
import com.sumup.mgcodereviewer.service.DroneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DroneController {
    private final DroneService droneService;

    @Operation(summary = "Get current drone coordinates")
    @GetMapping("/position")
    public String getPosition() {
        return droneService.getPosition();
    }

    @Operation(summary = "Move forward by a given distance")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Move was processed"),
            @ApiResponse(responseCode = "400", description = "Invalid distance, valid values are >=1")
    })
    @PostMapping("/position")
    public String move(@Valid @RequestBody DroneDistanceDto distanceDto) {
        return droneService.move(distanceDto.getDistance());
    }

    @Operation(summary = "Turn to a given direction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Turn was processed"),
            @ApiResponse(responseCode = "400", description = "Invalid direction, valid values are the cardinal directions")
    })
    @PostMapping("/direction")
    public String turn(@Valid @RequestBody DroneCardinalDirectionDto cardinalDirectionDto) {
        return droneService.turn(cardinalDirectionDto.getCardinalDirection());
    }
}
