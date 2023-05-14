package com.sumup.mgcodereviewer.service;

import com.sumup.mgcodereviewer.model.CardinalDirection;
import com.sumup.mgcodereviewer.model.Drone;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.sumup.mgcodereviewer.model.CardinalDirection.*;

@Service
@AllArgsConstructor
public class DroneService {
    private final Drone drone;
    private final static Map<CardinalDirection, CardinalDirection> OPPOSING_DIRECTIONS = new HashMap<>() {{
        put(NORTH, CardinalDirection.SOUTH);
        put(SOUTH, NORTH);
        put(EAST, WEST);
        put(WEST, EAST);
    }};

    public String getPosition() {
        return String.format("[%d, %d]", drone.getPointX(), drone.getPointY());
    }

    public String turn(CardinalDirection cardinalDirection) {
        if (OPPOSING_DIRECTIONS.get(drone.getCardinalDirection()) == cardinalDirection) {
            return getFormattedErrorMessage();
        }
        drone.setCardinalDirection(cardinalDirection);
        return getFormattedPosition();
    }

    public String move(int distance) {
        CardinalDirection droneCardinalDirection = drone.getCardinalDirection();
        if (droneCardinalDirection == NORTH || droneCardinalDirection == WEST) {
            distance = -distance;
        }

        return switch (droneCardinalDirection) {
            case EAST, WEST -> moveDroneHorizontally(distance);
            case NORTH, SOUTH -> moveDroneVertically(distance);
        };
    }

    private String moveDroneVertically(int distance) {
        int newPointY = drone.getPointY() + distance;
        if (isOutOfRange(newPointY, drone.getDroneField().getHeight())) {
            return getFormattedErrorMessage();
        }
        drone.setPointY(newPointY);
        return getFormattedPosition();
    }

    private String moveDroneHorizontally(int distance) {
        int newPointX = drone.getPointX() + distance;
        if (isOutOfRange(newPointX, drone.getDroneField().getWidth())) {
            return getFormattedErrorMessage();
        }
        drone.setPointX(newPointX);
        return getFormattedPosition();
    }

    private String getFormattedErrorMessage() {
        return String.format("Cannot do it [%d, %d], watching %s", drone.getPointX(), drone.getPointY(), drone.getCardinalDirection());
    }

    private String getFormattedPosition() {
        return String.format("I am on [%d, %d] watching %s", drone.getPointX(), drone.getPointY(), drone.getCardinalDirection());
    }

    private boolean isOutOfRange(int newPoint, int maxPointValue) {
        return newPoint <= 0 || newPoint > maxPointValue;
    }
}
