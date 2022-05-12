package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Antecedente;
import com.inserta.myfqcontroller.models.Evento;

import java.time.LocalDateTime;
import java.util.List;

public interface EventosService {
    public List<Evento> getEventos();
    public Evento getEventosById(Integer id);
    public List<Evento> getEventosDniPaciente(String dni);
    public List<Evento> getEventosDniPacienteAndFecha(String dni, LocalDateTime fecha);
}
