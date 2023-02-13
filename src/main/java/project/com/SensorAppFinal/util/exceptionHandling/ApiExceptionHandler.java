package project.com.SensorAppFinal.util.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.com.SensorAppFinal.util.exceptions.MeasurementException;
import project.com.SensorAppFinal.util.exceptions.SensorException;

import java.time.ZonedDateTime;


@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleArgumentNotValidException(MeasurementException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(),   ZonedDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleSensorException(SensorException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(),   ZonedDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
