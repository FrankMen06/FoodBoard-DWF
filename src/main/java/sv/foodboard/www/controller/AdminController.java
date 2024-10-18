package sv.foodboard.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

@Controller
public class AdminController {
    @GetMapping("/login")
    public String login() {
        return "loginEmple";
    }

    @GetMapping("/admin/inicio")
    public String inicioAdmin(Model model) {
        // Obtener la autenticación del usuario
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String nombreAdmin = authentication.getName();  // Obtener el nombre del administrador autenticado

        // Pasar el nombre al modelo
        model.addAttribute("nombreAdmin", nombreAdmin);
        return "admin/inicioAdmin";
    }
    @GetMapping("/admin/gestionar_empleados")
    public String gestionar_empleados() {
        return "admin/gestionar_empleados";
    }
    @GetMapping("/admin/mesas")
    public String mesas() {
        return "admin/mesas";
    }
    @GetMapping("/admin/ventas")
    public String ventas() {
        return "admin/ventas";
    }
    @GetMapping("/admin/sectores")
    public String sectores() {
        return "admin/sectores";
    }
    @GetMapping("/admin/productos")
    public String productos() {
        return "admin/productos";
    }
    @GetMapping("/admin/detalle")
    public String detalle() {
        return "admin/detalle";
    }



}
