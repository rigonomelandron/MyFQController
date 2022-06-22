package com.inserta.myfqcontroller.controllers;


import com.inserta.myfqcontroller.models.Glicada;
import com.inserta.myfqcontroller.services.GlicadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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

    public List<Glicada> glicadasByUserFecha(@PathVariable String dni, @PathVariable String fecha) throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        return glicadasService.getGlicadasByDniAndFecha(dni, date);
    }

    @GetMapping("/glicadas/fechas/{desde}/{hasta}")
    public List<Glicada> findAllByFechaBetween(@PathVariable Date desde, @PathVariable Date hasta) throws ParseException {

        return glicadasService.findAllByFechaBetween(desde, hasta);

    }
    @GetMapping("/glicadas/idUsuario/{idUsuario}/{fecha}")
    public List<Glicada> findAllByIdUsuarioAndFecha(@PathVariable String idUsuario, @PathVariable Date fecha) {

        return glicadasService.findAllByPacienteIdUsuarioAndFecha(idUsuario, fecha);
    }
}
