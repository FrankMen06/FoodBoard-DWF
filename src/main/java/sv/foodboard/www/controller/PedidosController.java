package sv.foodboard.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PedidosController {

    @GetMapping("/pedidos/inicioPedidos")
    public String inicioPedidos() {
        return "pedidos/inicioPedidos";
    }
}
