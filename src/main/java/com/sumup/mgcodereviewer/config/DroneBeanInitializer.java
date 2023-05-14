package com.sumup.mgcodereviewer.config;

import com.sumup.mgcodereviewer.model.CardinalDirection;
import com.sumup.mgcodereviewer.model.Drone;
import com.sumup.mgcodereviewer.model.DroneField;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DroneBeanInitializer {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Drone initDrone() {
        DroneField droneField = new DroneField(10, 10);
        return new Drone(5, 5, CardinalDirection.SOUTH, droneField);
    }
}
