package com.sumup.mgcodereviewer.model;

import lombok.*;

@Data
public class DroneField {
    private final int width;
    private final int height;

    public DroneField(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
