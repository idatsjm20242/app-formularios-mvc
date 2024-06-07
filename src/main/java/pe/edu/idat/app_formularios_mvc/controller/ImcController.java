package pe.edu.idat.app_formularios_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.app_formularios_mvc.model.ImcModel;

@Controller
public class ImcController {

    @GetMapping("/imc")
    public String imc(Model model){
        model.addAttribute("mostrar",
                false);
        model.addAttribute("objimc",
                new ImcModel());
        return "frmimc";
    }

    @PostMapping("/imc")
    public String calcularImc(){
        return "frmimc";
    }


}
