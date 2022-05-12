package com.inserta.myfqcontroller.controllers;

import com.inserta.myfqcontroller.models.CicloAntibiotico;
import com.inserta.myfqcontroller.services.CiclosAntibioticoService;
import com.inserta.myfqcontroller.services.CiclosAntibioticoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/api/v1")
@RestController
public class CiclosAntibioticoController {
    @Autowired
    CiclosAntibioticoService ciclosAntibioticoService;

    @GetMapping("/ciclos-antibiotico")
    public List<CicloAntibiotico> getCiclosAntibiotico(){
        return ciclosAntibioticoService.getCiclosAntibiotico();
    }

    @GetMapping("/ciclos-antibiotico/{dni}")
    public List<CicloAntibiotico> getCiclosAntibioticoByDni(@PathVariable String dni){
        return ciclosAntibioticoService.getCiclosAntibioticoByDni(dni);
    }

    @GetMapping("/ciclos-antibiotico/{dni}/{fecha}")
    public List<CicloAntibiotico> getCiclosAntibioticoByDni(@PathVariable String dni, @PathVariable LocalDateTime fecha){
        return ciclosAntibioticoService.getCiclosAntibioticoByDniAndFechaInicio(dni, fecha);
    }

    @GetMapping("/ciclos-antibiotico/intravenosos")
    public List<CicloAntibiotico> getCiclosAntibioticoByEsIntravenosoIsTrue(){
        return ciclosAntibioticoService.getCiclosAntibioticoByEsIntravenosoTrue();
    }

    @GetMapping("/ciclos-antibiotico/{id}")
    public CicloAntibiotico getCicloAntibioticoById(@PathVariable String id){
        Integer idI = Integer.valueOf(id);
        return ciclosAntibioticoService.getCiclosAntibioticoById(idI);
    }
}
