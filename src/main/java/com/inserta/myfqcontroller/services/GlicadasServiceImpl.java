package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Glicada;
import com.inserta.myfqcontroller.repos.GlicadasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GlicadasServiceImpl implements GlicadasService{
    @Autowired
    GlicadasRepo glicadasRepo;
    @Override
    public List<Glicada> getGlicadas() {
        return glicadasRepo.findAll();
    }

    @Override
    public Glicada getGlicadasById(Integer id) {
        return glicadasRepo.findById(id).orElse(null);
    }

    @Override
    public List<Glicada> getGlicadasByDni(String dni) {
        return glicadasRepo.findByDni_paciente(dni);
    }

    @Override
    public List<Glicada> getGlicadasByDniAndFecha(String dni, LocalDateTime fecha) {
        return glicadasRepo.findByDni_pacienteAndFecha(dni, fecha);
    }
}
