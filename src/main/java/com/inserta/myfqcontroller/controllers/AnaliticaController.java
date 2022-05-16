package com.inserta.myfqcontroller.controllers;



import com.inserta.myfqcontroller.models.Analitica;
import com.inserta.myfqcontroller.services.AnaliticasService;
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
public class AnaliticaController {
    @Autowired
    private AnaliticasService analiticasService;

    @GetMapping("/analiticas/listado")
    public List<Analitica> listadoAnaliticas (){
        return analiticasService.getAnaliticas();
    }

    @GetMapping("/analiticas/id/{id}")
    public Analitica analiticaById(@PathVariable int id){
        return analiticasService.getAnaliticasById(id);
    }

    @GetMapping("/analiticas/dni/{dni}")
    public List<Analitica> analiticasByDni(@PathVariable String dni){
        return analiticasService.getAnaliticasByDni(dni);

    }

    @GetMapping("/analiticas/dniFecha/{dni}/{fecha}")

    public List<Analitica> analiticasByUserFecha(@PathVariable String dni, @PathVariable String fecha) throws ParseException {

        Date date =new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        return analiticasService.getAnaliticasByDniAndFecha(dni, date);
    }

}
