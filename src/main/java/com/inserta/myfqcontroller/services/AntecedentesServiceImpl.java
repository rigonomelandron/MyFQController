package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Antecedente;
import com.inserta.myfqcontroller.models.CicloAntibiotico;
import com.inserta.myfqcontroller.repos.AntecedentesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AntecedentesServiceImpl implements AntecedentesService{

    @Autowired
    AntecedentesRepo antecedentesRepo;

    @Override
    public Antecedente getAntecedenteById(Integer id) {
        return antecedentesRepo.findById(id).orElse(null);
    }

    @Override
    public List<Antecedente> getAntecedentes() {
        return antecedentesRepo.findAll();
    }

    @Override
    public List<Antecedente> getAntecedentesByDni(String dni) {
        return antecedentesRepo.findByDniPaciente(dni);
    }

    @Override
    public List<Antecedente> getAntecedentesByDniAndFecha(String dni, LocalDateTime fecha) {
        return antecedentesRepo.findByDniPacienteAndFecha(dni, fecha);
    }
}
