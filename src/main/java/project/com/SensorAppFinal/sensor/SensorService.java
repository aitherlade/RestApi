package project.com.SensorAppFinal.sensor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SensorService {

    private final ModelMapper modelMapper;
    private final SensorRepository sensorRepository;

    public SensorService(ModelMapper modelMapper, SensorRepository sensorRepository) {
        this.modelMapper = modelMapper;
        this.sensorRepository = sensorRepository;
    }

    public void save(SensorDTO sensorDTO) {
        sensorRepository.save(toSensor(sensorDTO));

    }

    public List<SensorDTO> getAll() {
        return sensorRepository.findAll().stream().map(sensor -> toSensorDTO(sensor)).collect(Collectors.toList());
    }

    public Sensor toSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }

    public SensorDTO toSensorDTO(Sensor sensor) {
        return modelMapper.map(sensor, SensorDTO.class);
    }

    public Optional<Sensor> findByName(String name) {
        return sensorRepository.findByName(name);
    }
}
