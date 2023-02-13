package project.com.SensorAppFinal.measurment;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import project.com.SensorAppFinal.sensor.Sensor;

public class MeasurementDTO {

    @NotNull
    @Min(-100)
    @Max(100)
    private double value;
    @NotNull
    private boolean raining;
    @NotNull
    private Sensor sensor;

    public MeasurementDTO() {
    }

    public MeasurementDTO(double value, boolean raining, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

}
