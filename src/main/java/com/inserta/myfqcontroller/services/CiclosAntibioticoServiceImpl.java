package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Antecedente;
import com.inserta.myfqcontroller.models.CicloAntibiotico;
import com.inserta.myfqcontroller.repos.CiclosAntibioticosRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class CiclosAntibioticoServiceImpl implements CiclosAntibioticoService {

    @Autowired
    CiclosAntibioticosRepo ciclosAntibioticosRepo;

    @Override
    public List<CicloAntibiotico> getCiclosAntibiotico() {
        return ciclosAntibioticosRepo.findAll();
    }

    @Override
    public List<CicloAntibiotico> getCiclosAntibioticoByDni(String dni) {
        return ciclosAntibioticosRepo.findByDniPaciente(dni);
    }

    @Override
    public List<CicloAntibiotico> getCiclosAntibioticoByDniAndFechaInicio(String dni, LocalDateTime fecha) {
        return ciclosAntibioticosRepo.findByDniPacienteAndFechaInicio(dni, fecha);
    }

    @Override
    public List<CicloAntibiotico> getCiclosAntibioticoByEsIntravenosoTrue() {
        return ciclosAntibioticosRepo.findByEsIntravenosoTrue();
    }

    @Override
    public CicloAntibiotico getCiclosAntibioticoById(Integer id) {
        return ciclosAntibioticosRepo.findById(id).orElse(null);
    }
}
