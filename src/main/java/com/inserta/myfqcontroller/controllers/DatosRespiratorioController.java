package com.inserta.myfqcontroller.controllers;

import com.inserta.myfqcontroller.models.DatoRespiratorio;
import com.inserta.myfqcontroller.services.DatosRespiratoriosService;
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
public class DatosRespiratorioController {
    @Autowired
    DatosRespiratoriosService datosRespiratoriosService;

    @GetMapping("/datos-respiratorios")
    public List<DatoRespiratorio> getDatosRespiratorios(){
        return datosRespiratoriosService.getDatosRespiratorios();
    }

    @GetMapping("/datos-respiratorios/dni/{dni}")
    public List<DatoRespiratorio> getDatosRespiratoriosByDni(@PathVariable String dni){
        return datosRespiratoriosService.getDatosRespiratorios();
    }

    @GetMapping("/datos-respiratorios/dni/{dni}/{fecha}")
    public List<DatoRespiratorio> getDatosRespiratoriosByDni(@PathVariable String dni, @PathVariable String fecha){
        LocalDateTime fechaI = LocalDateTime.parse(fecha);
        return datosRespiratoriosService.getDatosRespiratoriosByDniAndFecha(dni, fechaI);
    }

    @GetMapping("/datos-respiratorios/id/{id}")
    public DatoRespiratorio getDatosRespiratoriosById(@PathVariable String id){
        Integer idI = Integer.valueOf(id);
        return datosRespiratoriosService.getDatoRespiratorioById(idI);
    }
}
