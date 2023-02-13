package project.com.SensorAppFinal.sensor;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import project.com.SensorAppFinal.measurment.MeasurementDTO;
import project.com.SensorAppFinal.measurment.MeasurementService;
import project.com.SensorAppFinal.util.exceptions.SensorException;
import project.com.SensorAppFinal.util.validators.SensorValidator;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    private final SensorService sensorService;
    private final SensorValidator sensorValidator;

    public SensorController(SensorService sensorService, MeasurementService measurementService, SensorValidator sensorValidator) {
        this.sensorService = sensorService;
        this.sensorValidator = sensorValidator;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration (@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {


        sensorValidator.validate(sensorService.toSensor(sensorDTO), bindingResult);
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage() == null ? error.getCode() : error.getDefaultMessage())
                        .append(";");
            }

            throw new SensorException(errorMsg.toString());

        }
        sensorService.save(sensorDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/get")
    public Map<String, List<SensorDTO>> getSensors() {
        return Collections.singletonMap("sensors", sensorService.getAll());
    }
}



