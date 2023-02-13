package project.com.SensorAppFinal.util.validators;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import project.com.SensorAppFinal.measurment.Measurement;
import project.com.SensorAppFinal.measurment.MeasurementService;
import project.com.SensorAppFinal.sensor.SensorService;

@Service
public class MeasurementValidator implements Validator {
    private final SensorService sensorService;

    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Measurement.class);

    }

    @Override
    public void validate(Object o, Errors errors) {
        Measurement measurement = (Measurement) o;
        if (sensorService.findByName(measurement.getSensor().getName()).isEmpty())
            errors.rejectValue("sensor", "No sensor with that name was found");
    }
}

