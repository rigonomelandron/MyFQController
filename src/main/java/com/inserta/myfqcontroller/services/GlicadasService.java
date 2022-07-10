package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Glicada;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface GlicadasService {
     List<Glicada> getGlicadas();
     Glicada getGlicadasById(Integer id);
     List<Glicada> getGlicadasByDni(String dni);
     List<Glicada> getGlicadasByDniAndFecha(String dni, Date fecha);
     List<Glicada> findAllByFechaBetween(Date desde, Date hasta);
     List<Glicada> findAllByPacienteIdUsuarioAndFecha(int idUsuario, Date fecha);

}
