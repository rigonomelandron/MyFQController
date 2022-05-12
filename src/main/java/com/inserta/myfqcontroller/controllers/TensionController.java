package com.inserta.myfqcontroller.controllers;


import com.inserta.myfqcontroller.models.Deporte;
import com.inserta.myfqcontroller.models.Tension;
import com.inserta.myfqcontroller.services.TensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TensionController {

    @Autowired
    private TensionService tensionService;

    @GetMapping("/tension/listado")
    public List<Tension> listadoDeporte (){
        return tensionService.listado();
    }

    @GetMapping("/tension/id/{id}")
    public Tension deporteById(@PathVariable int id){
        return tensionService.tensionById(id);
    }

    @GetMapping("/tension/dni/{dni}")
    public List<Tension> deporteByDni(@PathVariable String dni){
        return tensionService.tensionByDni(dni);

    }

    @GetMapping("/tension/dniFecha/{dni}/{fecha}")

    public List<Tension> deporteByUserFecha(@PathVariable String dni, @PathVariable LocalDateTime fecha){
        return tensionService.tensionByDniFecha(dni, fecha);
    }
}
