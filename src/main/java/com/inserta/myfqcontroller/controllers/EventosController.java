package com.inserta.myfqcontroller.controllers;



import com.inserta.myfqcontroller.models.Evento;
import com.inserta.myfqcontroller.services.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class EventosController {

    @Autowired
    private EventosService eventosService;

    @GetMapping("/eventos/listado")
    public List<Evento> listadoEventos (){
        return eventosService.getEventos();
    }

    @GetMapping("/eventos/id/{id}")
    public Evento eventosById(@PathVariable int id){
        return eventosService.getEventosById(id);
    }

    @GetMapping("/eventos/dni/{dni}")
    public List<Evento> eventosByDni(@PathVariable String dni){
        return eventosService.getEventosDniPaciente(dni);

    }

    @GetMapping("/eventos/dniFecha/{dni}/{fecha}")

    public List<Evento> eventosByUserFecha(@PathVariable String dni, @PathVariable String fecha){

        LocalDateTime fechaActual = LocalDateTime.parse(fecha);
        return eventosService.getEventosDniPacienteAndFecha(dni, fechaActual);
    }

}