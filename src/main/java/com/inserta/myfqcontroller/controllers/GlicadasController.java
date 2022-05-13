package com.inserta.myfqcontroller.controllers;


import com.inserta.myfqcontroller.models.Glicada;
import com.inserta.myfqcontroller.services.GlicadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class GlicadasController {

    @Autowired
    private GlicadasService glicadasService;

    @GetMapping("/glicadas/listado")
    public List<Glicada> listadoGlicadas (){
        return glicadasService.getGlicadas();
    }

    @GetMapping("/glicadas/id/{id}")
    public Glicada glicadasById(@PathVariable int id){
        return glicadasService.getGlicadasById(id);
    }

    @GetMapping("/glicadas/dni/{dni}")
    public List<Glicada> glicadasByDni(@PathVariable String dni){
        return glicadasService.getGlicadasByDni(dni);

    }

    @GetMapping("/glicadas/dniFecha/{dni}/{fecha}")

    public List<Glicada> glicadasByUserFecha(@PathVariable String dni, @PathVariable String fecha){

        LocalDateTime fechaActual = LocalDateTime.parse(fecha);
        return glicadasService.getGlicadasByDniAndFecha(dni, fechaActual);
    }
}
