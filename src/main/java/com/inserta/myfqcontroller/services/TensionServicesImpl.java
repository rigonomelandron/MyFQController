package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Tension;
import com.inserta.myfqcontroller.repos.TensionesRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TensionServicesImpl implements TensionService{

    @Autowired
    private TensionesRepos tensionesRepos;
    @Override
    public List<Tension> listado() {
        return tensionesRepos.findAll();
    }

    @Override
    public Tension tensionById(int id) {
        return tensionesRepos.findById(id).orElse(null);
    }

    @Override
    public List<Tension> tensionByDni(String dni) {
        return tensionesRepos.findByDniPaciente(dni);
    }

    @Override
    public List<Tension> tensionByDniFecha(String dni, LocalDateTime fecha) {
        return tensionesRepos.findByDniPacienteAndFecha(dni,fecha);
    }
}
