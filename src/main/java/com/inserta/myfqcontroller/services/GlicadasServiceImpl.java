package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Glicada;
import com.inserta.myfqcontroller.repos.GlicadasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
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
        return glicadasRepo.findByPaciente_Dni(dni);
    }

    @Override
    public List<Glicada> getGlicadasByDniAndFecha(String dni, Date fecha) {
        return glicadasRepo.findByPaciente_DniAndFecha(dni, fecha);
    }

    @Override
    public List<Glicada> findAllByFechaBetween(Date desde, Date hasta) {
        return glicadasRepo.findAllByFechaBetween(desde,hasta);
    }

    @Override
    public List<Glicada> findAllByPacienteIdUsuarioAndFecha(int idUsuario, Date fecha) {
        return glicadasRepo.findAllByPaciente_IdUsuarioAndFecha(idUsuario,fecha);
    }

}
