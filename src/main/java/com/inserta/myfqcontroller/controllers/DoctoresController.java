package com.inserta.myfqcontroller.controllers;

import com.inserta.myfqcontroller.models.Doctor;
import com.inserta.myfqcontroller.services.DoctoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin(origins = "*")
public class DoctoresController {
    @Autowired
    private DoctoresService doctoresService;

    @GetMapping("/doctores/listado")
    public List<Doctor> listadoDoctores(){
        return doctoresService.getDoctores();
    }


    @GetMapping("/doctores/colegiado/{numero}")
    public Doctor DoctorByDni(@PathVariable String numero){
        return doctoresService.getDoctorByNumColegiado(numero);

    }
    @GetMapping("/doctores/usuario/{idUsuario}")
    public Doctor doctorByIdUsuario(@PathVariable Integer idUsuario){
        return doctoresService.getDoctorByIdUsuario(idUsuario);

    }
    @PostMapping("/doctores/save")
    public Doctor saveDoctor(@RequestBody Doctor doctor){
        return doctoresService.saveDoctor(doctor);
    }
    @PatchMapping("/doctores/update")
    public Doctor updateDoctor(@RequestBody Doctor doctor){
        return doctoresService.modificarDoctor(doctor);
    }
    @DeleteMapping("/doctores/delete/{numero}")
    public Doctor deleteDoctor(@PathVariable String numero){
        return doctoresService.deleteDoctor(numero);
    }


}
