package sv.foodboard.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecepcionistaController {

    @GetMapping("/recepcionista/inicioRecepcionista")
    public String inicioRecepcionista() {
        return "recepcionista/inicioRecepcionista";
    }
}
