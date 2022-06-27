package com.inserta.myfqcontroller.controllers;

import com.inserta.myfqcontroller.models.Equipo;
import com.inserta.myfqcontroller.services.EquiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
@RestController
public class EquiposController {
    @Autowired
    EquiposService equiposService;

    @GetMapping("/equipos")
    public List<Equipo> getEquipos(){
        return equiposService.getEquipos();
    }

    @GetMapping("/equipos/id/{id}")
    public Equipo getEquiposById(@PathVariable String id){
        Integer idI = Integer.valueOf(id);
        return equiposService.getEquiposById(idI);
    }
    @GetMapping("/equipos/idMedico/{idMedico}")
    public List<Equipo> getEquiposByIdMedico(@PathVariable String idMedico){
        return equiposService.getEquiposByIdMedico(idMedico);
    }
    @GetMapping("/equipos/idPaciente/{idPaciente}")
    public Equipo getEquiposByIdPaciente(@PathVariable String idPaciente){
        return equiposService.getEquiposByIdPaciente(idPaciente);
    }
}
