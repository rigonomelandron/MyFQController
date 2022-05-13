package com.inserta.myfqcontroller.controllers;



import com.inserta.myfqcontroller.models.Paciente;
import com.inserta.myfqcontroller.services.PacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class PacientesController {


    @Autowired
    private PacientesService pacientesService;

    @GetMapping("/pacientes/listado")
    public List<Paciente> listadoPacientes(){
        return pacientesService.getPacientes();
    }


    @GetMapping("/pacientes/dni/{dni}")
    public Paciente pacienteByDni(@PathVariable String dni){
        return pacientesService.getPacienteByDni(dni);

    }


}
