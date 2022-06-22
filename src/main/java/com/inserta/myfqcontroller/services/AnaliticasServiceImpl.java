package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Analitica;
import com.inserta.myfqcontroller.repos.AnaliticasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
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
        return analiticasRepo.findByPaciente_Dni(dni);
    }

    @Override
    public List<Analitica> getAnaliticasByDniAndFecha(String dni, Date fecha) {

        return analiticasRepo.findByPaciente_DniAndFecha(dni, fecha);
    }

    @Override
    public List<Analitica> getAnaliticasByIdUsuarioFecha(String idUsuario, Date fecha) {
        return analiticasRepo.findAllByPaciente_IdUsuarioEqualsAndFecha(idUsuario, fecha);
    }
}
