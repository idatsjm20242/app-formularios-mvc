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
    public String calcularImc(ImcModel imcModel,
                              Model model){
        Double tallam = imcModel.getTalla() / 100;
        Double valorImc = imcModel.getPeso() / (tallam * tallam);
        String diagnostico = "";
        if(valorImc <= 16){
            diagnostico = "por debajo del peso";
        }else if(valorImc <= 19){
            diagnostico = "con peso normal";
        }else if(valorImc <= 24){
            diagnostico = "con obesidad leve";
        }else if(valorImc <= 29){
            diagnostico = "con obesidad media";
        }else {
            diagnostico = "con obesidad mórbida";
        }
        model.addAttribute("mostrar",
                true);
        model.addAttribute("resultado",
                "Su Valor IMC es: " + valorImc +
                " usted se encuentra: " + diagnostico);
        model.addAttribute("objimc",
                new ImcModel());
        return "frmimc";
    }


}
