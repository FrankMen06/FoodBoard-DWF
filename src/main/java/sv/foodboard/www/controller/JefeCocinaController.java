package sv.foodboard.www.controller;

import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JefeCocinaController {

    @GetMapping("/jefeCocina/inicioJefeCocina")
    public String inicioJefeCocina() {
        return "jefeCocina/inicioJefeCocina";
    }
}
