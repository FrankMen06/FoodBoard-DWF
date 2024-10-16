package sv.foodboard.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

    @GetMapping("/cliente/inicioCliente")
    public String inicioCliente() {
        return "clientes/inicioCliente";
    }
}
