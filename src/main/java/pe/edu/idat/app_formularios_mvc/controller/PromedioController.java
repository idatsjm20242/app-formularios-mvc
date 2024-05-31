package pe.edu.idat.app_formularios_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PromedioController {

    @GetMapping("/promedio")
    public String frmPromedio(){
        return "frmpromedio";
    }
}
