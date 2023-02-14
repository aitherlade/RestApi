package project.com.SensorAppFinal.util.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import project.com.SensorAppFinal.sensor.Sensor;
import project.com.SensorAppFinal.sensor.SensorService;
@Service
public class SensorValidator implements Validator {
   private final  SensorService sensorService;

    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals( Sensor.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Sensor sensor = (Sensor) o;
        if (sensorService.findByName(sensor.getName()).isPresent())
            errors.rejectValue("name", "Sensor with that name already exists");
    }
}
