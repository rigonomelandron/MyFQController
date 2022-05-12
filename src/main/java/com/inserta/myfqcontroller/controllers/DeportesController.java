package com.inserta.myfqcontroller.controllers;



import com.inserta.myfqcontroller.models.Deporte;
import com.inserta.myfqcontroller.services.DeportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DeportesController {

    @Autowired
    private DeportesService deportesService;

    @GetMapping("/deportes/listado")
    public List<Deporte> listadoDeporte (){
        return deportesService.listado();
    }

    @GetMapping("/deportes/id/{id}")
    public Deporte deporteById(@PathVariable int id){
        return deportesService.deporteById(id);
    }

    @GetMapping("/deportes/dni/{dni}")
    public List<Deporte> deporteByDni(@PathVariable String dni){
        return deportesService.deportesByDni(dni);

    }

    @GetMapping("/deportes/dniFecha/{dni}/{fecha}")

    public List<Deporte> deporteByUserFecha(@PathVariable String dni, @PathVariable String fecha){
        LocalDateTime fechaActual = LocalDateTime.parse(fecha);
        return deportesService.deportesByDniFecha(dni, fechaActual);
    }

}