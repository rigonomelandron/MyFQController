package com.inserta.myfqcontroller.services;


import com.inserta.myfqcontroller.models.CicloAntibiotico;
import com.inserta.myfqcontroller.repos.CiclosAntibioticosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CiclosAntibioticoServiceImpl implements CiclosAntibioticoService {

    @Autowired
    CiclosAntibioticosRepo ciclosAntibioticosRepo;

    @Override
    public List<CicloAntibiotico> getCiclosAntibiotico() {
        return ciclosAntibioticosRepo.findAll();
    }

    @Override
    public List<CicloAntibiotico> getCiclosAntibioticoByDni(String dni) {
        return ciclosAntibioticosRepo.findByPaciente_Dni(dni);
    }

    @Override
    public List<CicloAntibiotico> getCiclosAntibioticoByDniAndFechaInicio(String dni, Date fecha) {
        return ciclosAntibioticosRepo.findByPaciente_DniAndFechaInicio(dni, fecha);
    }

    @Override
    public List<CicloAntibiotico> getCiclosAntibioticoByEsIntravenosoTrue() {
        return ciclosAntibioticosRepo.findByEsIntravenosoTrue();
    }

    @Override
    public CicloAntibiotico getCiclosAntibioticoById(Integer id) {
        return ciclosAntibioticosRepo.findById(id).orElse(null);
    }

    @Override
    public List<CicloAntibiotico> getCiclosAntibioticoByPaciente_IdUsuarioAndFechaInicio(String dni, Date fecha) {
        return ciclosAntibioticosRepo.findByPaciente_IdUsuarioAndFechaInicio(dni, fecha);
    }

    @Override
    public CicloAntibiotico addCiclosAntibiotico(CicloAntibiotico cicloAntibiotico) {
        return ciclosAntibioticosRepo.save(cicloAntibiotico);
    }
}
