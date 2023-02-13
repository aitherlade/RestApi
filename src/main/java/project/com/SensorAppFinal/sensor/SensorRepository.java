package project.com.SensorAppFinal.sensor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor,Integer> {
    Optional<Sensor> findByName(String name);
}
