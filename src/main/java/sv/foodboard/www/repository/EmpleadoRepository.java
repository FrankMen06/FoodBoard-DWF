package sv.foodboard.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.foodboard.www.model.Empleados;

public interface EmpleadoRepository extends JpaRepository<Empleados, String> {
}
