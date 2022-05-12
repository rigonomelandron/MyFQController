package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Analitica;
import com.inserta.myfqcontroller.repos.AnaliticasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnaliticasServiceImpl implements AnaliticasService{
    @Autowired
    AnaliticasRepo analiticasRepo;
    @Override
    public List<Analitica> getAnaliticas() {
        return analiticasRepo.findAll();
    }

    @Override
    public Analitica getAnaliticasById(Integer id) {
        return analiticasRepo.findById(id).orElse(null);
    }

    @Override
    public List<Analitica> getAnaliticasByDni(String dni) {
        return analiticasRepo.findByDni_paciente(dni);
    }

    @Override
    public List<Analitica> getAnaliticasByDniAndFecha(String dni, LocalDateTime fecha) {

        return analiticasRepo.findByDni_pacienteAndFecha(dni, fecha);
    }
}
