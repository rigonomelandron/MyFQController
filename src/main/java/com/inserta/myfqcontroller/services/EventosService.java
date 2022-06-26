package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Antecedente;
import com.inserta.myfqcontroller.models.Evento;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface EventosService {
     List<Evento> getEventos();
     Evento getEventosById(Integer id);
     List<Evento> getEventosDniPaciente(String dni);
     List<Evento> getEventosDniPacienteAndFecha(String dni, Date fecha);
     List<Evento> getEventosIdUsuarioFecha(String idUsuario, Date fecha);
     Evento createEvento(Evento evento);

}
