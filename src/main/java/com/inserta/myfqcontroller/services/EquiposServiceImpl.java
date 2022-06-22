package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Equipo;
import com.inserta.myfqcontroller.repos.EquiposRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquiposServiceImpl implements EquiposService{

    @Autowired
    EquiposRepo equiposRepo;


    @Override
    public List<Equipo> getEquipos() {
        return equiposRepo.findAll();
    }

    @Override
    public Equipo getEquiposById(Integer id) {
        return equiposRepo.findById(id).orElse(null);
    }

    @Override
    public List<Equipo> getEquiposByIdMedico(String idMedico) {
        return equiposRepo.findAllByIdMedico(idMedico);
    }
}
