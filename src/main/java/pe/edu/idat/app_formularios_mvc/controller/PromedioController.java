package pe.edu.idat.app_formularios_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.app_formularios_mvc.model.PromedioModel;

@Controller
public class PromedioController {

    @GetMapping("/promedio")
    public String frmPromedio(Model model){
        model.addAttribute("mostrar",
                false);
        model.addAttribute("objpromedio",
                new PromedioModel());
        return "frmpromedio";
    }
    @PostMapping("/promedio")
    public String calcularPromedio(PromedioModel promedioModel,
                                   Model model){
        Double valorEc1= promedioModel.getEc1()*0.04;
        Double valorEc2= promedioModel.getEc2()*0.12;
        Double valorEc3= promedioModel.getEc3()*0.24;
        Double valorEf= promedioModel.getEf()*0.6;
        Double promedioFinal = valorEc1 + valorEc2 + valorEc3 +valorEf;
        String resultado = "DESAPROBADO";
        if(promedioFinal >= 12.5){
            resultado = "APROBADO";
        }
        model.addAttribute("resultado",
                "Su promedio es: "+promedioFinal+
                        " ud se encuentra "+resultado);
        model.addAttribute("mostrar",
                true);
        model.addAttribute("objpromedio",
                new PromedioModel());
        return "frmpromedio";
    }

}
