package project.com.SensorAppFinal.measurment;

import org.springframework.data.jpa.repository.JpaRepository;
import project.com.SensorAppFinal.sensor.Sensor;

import java.util.Optional;

public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {
    int countAllByRainingIsTrue();
}
