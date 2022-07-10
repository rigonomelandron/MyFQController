package com.inserta.myfqcontroller.controllers;



import com.inserta.myfqcontroller.models.Evento;
import com.inserta.myfqcontroller.services.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin(origins = "*")
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

    public List<Evento> eventosByUserFecha(@PathVariable String dni, @PathVariable String fecha) throws ParseException {

        Date date =new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        return eventosService.getEventosDniPacienteAndFecha(dni, date);
    }

    @GetMapping("/eventos/idUsuario/{idUsuario}/{fecha}")
    public List<Evento> eventosByIdUsuarioFecha(@PathVariable Integer idUsuario, @PathVariable Date fecha) {


        return eventosService.getEventosIdUsuarioFecha(idUsuario, fecha);
    }
    @PostMapping("/evento")
    public Evento createEvento(@RequestBody Evento evento) {
        return eventosService.createEvento(evento);
    }


}
