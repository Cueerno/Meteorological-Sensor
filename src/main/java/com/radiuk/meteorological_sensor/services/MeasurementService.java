package com.radiuk.meteorological_sensor.services;

import com.radiuk.meteorological_sensor.models.Measurement;
import com.radiuk.meteorological_sensor.models.Sensor;
import com.radiuk.meteorological_sensor.repositories.MeasurementRepository;
import com.radiuk.meteorological_sensor.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorService sensorService;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }


    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    public Measurement findOne(int id) {
        return measurementRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementRepository.save(measurement);
    }

    private void enrichMeasurement(Measurement measurement) {
        measurement.setSensor(sensorService.findByName(measurement.getSensor().getName()).get());
        measurement.setMeasurementDateTime(LocalDateTime.now());
    }
}
