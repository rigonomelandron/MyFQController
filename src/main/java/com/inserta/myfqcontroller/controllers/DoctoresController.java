package com.inserta.myfqcontroller.controllers;

import com.inserta.myfqcontroller.models.Doctor;
import com.inserta.myfqcontroller.services.DoctoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class DoctoresController {
    @Autowired
    private DoctoresService doctoresService;

    @GetMapping("/doctores/listado")
    public List<Doctor> listadoDoctores(){
        return doctoresService.getDoctores();
    }


    @GetMapping("/doctores/colegiado/{numero}")
    public Doctor pacienteByDni(@PathVariable String numero){
        return doctoresService.getDoctorByNumColegiado(numero);

    }
}
