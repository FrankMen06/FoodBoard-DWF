package sv.foodboard.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MeseroController {

    @GetMapping("/mesero/inicioMesero")
    public String inicioMesero() {
        return "mesero/inicioMesero";
    }
}
