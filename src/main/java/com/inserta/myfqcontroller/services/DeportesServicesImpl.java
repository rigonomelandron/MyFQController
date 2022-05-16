package com.inserta.myfqcontroller.services;


import com.inserta.myfqcontroller.models.Deporte;
import com.inserta.myfqcontroller.repos.DeportesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeportesServicesImpl implements DeportesService{

    @Autowired
    private DeportesRepo deportesRepo;
    @Override
    public List<Deporte> listado() {
        return deportesRepo.findAll();
    }

    @Override
    public Deporte deporteById(int id) {
        return deportesRepo.findById(id).orElse(null);
    }

    @Override
    public List<Deporte> deportesByDni(String dni) {
        return deportesRepo.findByPaciente_Dni(dni);
    }

    @Override
    public List<Deporte> deportesByDniFecha(String dni, LocalDateTime fecha) {
        return deportesRepo.findByPaciente_DniAndFecha(dni,fecha);
    }
}
