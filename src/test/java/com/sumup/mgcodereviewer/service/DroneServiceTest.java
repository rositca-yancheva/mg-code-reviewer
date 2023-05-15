package com.sumup.mgcodereviewer.service;

import com.sumup.mgcodereviewer.model.CardinalDirection;
import com.sumup.mgcodereviewer.model.Drone;
import com.sumup.mgcodereviewer.model.DroneField;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DroneServiceTest {
    @InjectMocks
    private DroneService droneService;
    @Mock
    private Drone drone;

    @ParameterizedTest
    @EnumSource(value = CardinalDirection.class, mode = EnumSource.Mode.EXCLUDE, names = {"NORTH"})
    void turn_valid(CardinalDirection direction) {
        // given
        when(drone.getCardinalDirection()).thenReturn(CardinalDirection.SOUTH);

        // when
        String actual = droneService.turn(direction);

        // then
        verify(drone).setCardinalDirection(direction);
    }

    @Test
    void turn_invalid() {
        // given
        when(drone.getCardinalDirection()).thenReturn(CardinalDirection.SOUTH);

        // when
        droneService.turn(CardinalDirection.NORTH);

        // then
        verify(drone, never()).setCardinalDirection(any());
    }

    @Test
    void move_horizontally_valid() {
        // given
        int initialX = 5;
        int distance = 4;
        when(drone.getPointX()).thenReturn(initialX);
        when(drone.getPointY()).thenReturn(5);
        when(drone.getCardinalDirection()).thenReturn(CardinalDirection.EAST);
        when(drone.getDroneField()).thenReturn(new DroneField(10, 10));

        // when
        droneService.move(distance);

        // then
        verify(drone).setPointX(initialX + distance);
    }

    @Test
    void move_horizontally_invalid() {
        // given
        int initialX = 5;
        int distance = 6;
        when(drone.getPointX()).thenReturn(initialX);
        when(drone.getPointY()).thenReturn(5);
        when(drone.getCardinalDirection()).thenReturn(CardinalDirection.EAST);
        when(drone.getDroneField()).thenReturn(new DroneField(10, 10));

        // when
        droneService.move(distance);

        // then
        verify(drone, never()).setPointX(anyInt());
    }

    @Test
    void move_vertically_valid() {
        // given
        int initialY = 5;
        int distance = 4;
        when(drone.getPointX()).thenReturn(5);
        when(drone.getPointY()).thenReturn(initialY);
        when(drone.getCardinalDirection()).thenReturn(CardinalDirection.NORTH);
        when(drone.getDroneField()).thenReturn(new DroneField(10, 10));

        // when
        droneService.move(distance);

        // then
        verify(drone).setPointY(initialY - distance);
    }

    @Test
    void move_vertically_invalid() {
        // given
        int initialY = 5;
        int distance = 6;
        when(drone.getPointX()).thenReturn(5);
        when(drone.getPointY()).thenReturn(initialY);
        when(drone.getCardinalDirection()).thenReturn(CardinalDirection.NORTH);
        when(drone.getDroneField()).thenReturn(new DroneField(10, 10));

        // when
        droneService.move(distance);

        // then
        verify(drone, never()).setPointY(anyInt());
    }
}