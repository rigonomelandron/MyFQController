package com.inserta.myfqcontroller.services;


import com.inserta.myfqcontroller.models.Tension;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TensionService {

    List<Tension> listado();
    Tension tensionById(int id);
    List<Tension> tensionByDni(String dni);
    List<Tension> tensionByDniFecha(String dni, Date fecha);

    List<Tension> findAllByFechaBetween(Date desde, Date hasta);
    List<Tension> findAllByPaciente_IdUsuarioAndFecha(String idUsuario, Date fecha);
}
