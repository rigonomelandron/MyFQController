package com.inserta.myfqcontroller.controllers;



import com.inserta.myfqcontroller.models.Deporte;
import com.inserta.myfqcontroller.services.DeportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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

    public List<Deporte> deporteByUserFecha(@PathVariable String dni, @PathVariable String fecha) throws ParseException {
        Date date =new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        return deportesService.deportesByDniFecha(dni, date);
    }

    @GetMapping ("/deportes/idUsuario/{idUsuario}/{fecha}")
    public List<Deporte> deporteByIdUsuarioFecha(@PathVariable String idUsuario, @PathVariable Date fecha) {

        return deportesService.deportesByIdUsuarioFecha(idUsuario, fecha);
    }
    @PostMapping("/deportes")
    public Deporte addDeporte(@RequestBody Deporte deporte){
        return deportesService.addDeporte(deporte);
    }

}
