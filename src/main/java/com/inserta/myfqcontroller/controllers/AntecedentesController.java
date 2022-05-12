package com.inserta.myfqcontroller.controllers;

import com.inserta.myfqcontroller.models.Antecedente;
import com.inserta.myfqcontroller.services.AntecedentesService;
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
public class AntecedentesController {
    @Autowired
    AntecedentesService antecedentesService;

    @GetMapping("/antecedentes")
    public List<Antecedente> getAntecedentes(){
        return antecedentesService.getAntecedentes();
    }

    @GetMapping("/antecedentes/dni/{dni}")
    public List<Antecedente> getAntecedentesByDni(@PathVariable String dni){
        return antecedentesService.getAntecedentesByDni(dni);
    }

    @GetMapping("/antecedentes/dni/{dni}/{fecha}")
    public List<Antecedente> getAntecedentesByDniAndFecha(@PathVariable String dni, @PathVariable String fecha){
        LocalDateTime fechaI = LocalDateTime.parse(fecha);
        return antecedentesService.getAntecedentesByDniAndFecha(dni, fechaI);
    }
    @GetMapping("/antecedentes/id/{id}")
    public Antecedente getAntecedentesById(@PathVariable String id){
        Integer idI = Integer.valueOf(id);
        return antecedentesService.getAntecedenteById(idI);
    }

}
