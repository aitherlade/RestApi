package project.com.SensorAppFinal.measurment;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import project.com.SensorAppFinal.sensor.SensorService;
import project.com.SensorAppFinal.util.exceptions.MeasurementException;
import project.com.SensorAppFinal.util.validators.MeasurementValidator;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementService measurementService;
    private final SensorService sensorService;
    private final  MeasurementValidator measurementValidator;

    public MeasurementController(MeasurementService measurementService, SensorService sensorService, MeasurementValidator measurementValidator) {
        this.measurementService = measurementService;
        this.sensorService = sensorService;
        this.measurementValidator = measurementValidator;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addMeasurements(@RequestBody @Valid MeasurementDTO measurementDTO, BindingResult bindingResult) {
        measurementValidator.validate(measurementService.toMeasurement( measurementDTO), bindingResult);
        if (bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            errors.forEach(fieldError -> stringBuilder
                    .append(fieldError.getField())
                    .append(" - ")
                    .append(fieldError.getDefaultMessage() == null ? fieldError.getCode() : fieldError.getDefaultMessage()));
            throw new MeasurementException(stringBuilder.toString());
        }
        measurementService.save(measurementDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/get")
    public Map<String, List<MeasurementDTO>> getMeasurements() {
        return Collections.singletonMap("measurements", measurementService.getMeasurements());

    }

    @GetMapping("/getRainyDaysCount")
    public Map<String, Integer> getRainyDaysCount() {
        return Collections.singletonMap("Rainy days", measurementService.getRainingDaysCount());
    }
}
