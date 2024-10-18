package sv.foodboard.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.foodboard.www.model.Empleados;
import sv.foodboard.www.repository.EmpleadoRepository;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleados> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    public void guardar(Empleados empleado) {
        empleadoRepository.save(empleado);
    }

    public void actualizar(Empleados empleado) {
        empleadoRepository.save(empleado);
    }

    public void eliminar(String codigo) {
        empleadoRepository.deleteById(codigo);
    }
}



