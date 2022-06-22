package com.inserta.myfqcontroller.controllers;


import com.inserta.myfqcontroller.models.Deporte;
import com.inserta.myfqcontroller.models.Tension;
import com.inserta.myfqcontroller.services.TensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

    public List<Tension> tensionByUserFecha(@PathVariable String dni, @PathVariable String fecha) throws ParseException {


        Date date =new SimpleDateFormat("yyyy-MM-dd").parse(fecha);

        return tensionService.tensionByDniFecha(dni, date);
    }
    @GetMapping("/tension/fechas/{desde}/{hasta}")
    public List<Tension>getBetween(@PathVariable Date desde, @PathVariable Date hasta) throws ParseException {

        return tensionService.findAllByFechaBetween(desde, hasta);
    }

    @PostMapping("/tension")
    public Tension guardarTension(@RequestBody Tension tension){
        return tension;
    }
    @GetMapping("/tension/idUsuario/{idUsuario}/{fecha}")
    public List<Tension> getByIdUsuarioAndDate(@PathVariable String idUsuario, @PathVariable Date fecha)  {

        return tensionService.findAllByPaciente_IdUsuarioAndFecha(idUsuario, fecha);
    }
}
