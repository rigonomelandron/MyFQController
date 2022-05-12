package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Paciente;
import com.inserta.myfqcontroller.repos.PacientesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientesServiceImpl implements PacientesService{
    @Autowired
    PacientesRepo pacientesRepo;
    @Override
    public List<Paciente> getPacientes() {
        return pacientesRepo.findAll();
    }

    @Override
    public Paciente getPacienteByDni(String dni) {
        return pacientesRepo.findByDni(dni);
    }
}
