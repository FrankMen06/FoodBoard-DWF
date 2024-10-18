package sv.foodboard.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sv.foodboard.www.model.Empleados;
import sv.foodboard.www.service.EmpleadoService;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public String listarEmpleados(Model model) {
        List<Empleados> empleados = empleadoService.obtenerTodos();
        model.addAttribute("empleados", empleados);
        model.addAttribute("empleado", new Empleados()); // Para el formulario
        return "/admin/gestionar_empleados"; // Vista única para gestionar empleados
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(@Valid @ModelAttribute("empleado") Empleados empleado, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Si hay errores, recuperamos la lista de empleados y retornamos a la vista
            model.addAttribute("empleados", empleadoService.obtenerTodos()); // Para mostrar la lista
            return "admin/gestionar_empleados"; // Volver a la vista del formulario si hay errores
        }
        empleadoService.guardar(empleado);
        model.addAttribute("mensaje", "Empleado guardado exitosamente!"); // Mensaje de éxito
        return "redirect:/empleados"; // Redirigir a la lista de empleados después de guardar
    }

    @PostMapping("/actualizar")
    public String actualizarEmpleado(@Valid @ModelAttribute("empleado") Empleados empleado, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Si hay errores, recuperamos la lista de empleados y retornamos a la vista
            model.addAttribute("empleados", empleadoService.obtenerTodos()); // Para mostrar la lista
            return "admin/gestionar_empleados"; // Volver a la vista del formulario si hay errores
        }
        empleadoService.actualizar(empleado);
        return "redirect:/empleados"; // Redirigir a la lista de empleados después de actualizar
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarEmpleado(@PathVariable("codigo") String codigo) {
        empleadoService.eliminar(codigo);
        return "redirect:/empleados"; // Redirigir a la lista de empleados después de eliminar
    }

}





