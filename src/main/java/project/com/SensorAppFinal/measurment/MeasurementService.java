package project.com.SensorAppFinal.measurment;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.com.SensorAppFinal.sensor.Sensor;
import project.com.SensorAppFinal.sensor.SensorRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    private final ModelMapper modelMapper;

    public MeasurementService(MeasurementRepository measurementRepository, SensorRepository sensorRepository, ModelMapper modelMapper) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
        this.modelMapper = modelMapper;
    }

    public void save(MeasurementDTO measurementDTO) {
        Measurement measurement=toMeasurement(measurementDTO);
        measurement.setMeasurementDateTime(LocalDateTime.now());
        Sensor sensor = sensorRepository.findByName(measurement.getSensor().getName()).get();
        measurement.setSensor(sensor);
        measurementRepository.save(measurement);
    }



    public List<MeasurementDTO> getMeasurements() {
        return measurementRepository.findAll().stream()
                .map(this::toMeasurementDTO).collect(Collectors.toList());
    }

    public MeasurementDTO toMeasurementDTO(Measurement measurement) {
        return modelMapper.map(measurement,MeasurementDTO.class);
    }
    public Measurement toMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO,Measurement.class);
    }

    public int getRainingDaysCount() {
        return measurementRepository.countAllByRainingIsTrue();
    }
}
