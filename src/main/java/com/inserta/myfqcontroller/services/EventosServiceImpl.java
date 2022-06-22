package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Evento;
import com.inserta.myfqcontroller.repos.EventosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class EventosServiceImpl implements EventosService {
    @Autowired
    EventosRepo eventosRepo;
    @Override
    public List<Evento> getEventos() {
        return eventosRepo.findAll();
    }

    @Override
    public Evento getEventosById(Integer id) {
        return eventosRepo.findById(id).orElse(null);
    }

    @Override
    public List<Evento> getEventosDniPaciente(String dni) {
        return eventosRepo.findByPaciente_Dni(dni);
    }

    @Override
    public List<Evento> getEventosDniPacienteAndFecha(String dni, Date fecha) {
        return eventosRepo.findByPaciente_DniAndFecha(dni, fecha);
    }

    @Override
    public List<Evento> getEventosIdUsuarioFecha(String idUsuario, Date fecha) {
        return eventosRepo.findByPaciente_IdUsuarioAndFecha(idUsuario, fecha);
    }
}
