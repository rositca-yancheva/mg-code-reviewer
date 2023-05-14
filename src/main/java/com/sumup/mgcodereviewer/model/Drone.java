package com.sumup.mgcodereviewer.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Drone {
    private int pointX;
    private int pointY;
    private CardinalDirection cardinalDirection;
    private final DroneField droneField;
}
