package project.com.SensorAppFinal.util.exceptionHandling;

import java.time.ZonedDateTime;

public class ErrorResponse {
    private String message;
    private   ZonedDateTime timestamp;

    public ErrorResponse(String message,   ZonedDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
