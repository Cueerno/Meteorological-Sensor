package com.radiuk.meteorological_sensor.dto;

import org.springframework.stereotype.Component;

@Component
public class MeasurementDTO {

    private Double value;

    private Boolean raining;

    private SensorDTO sensor;


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
