package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Equipo;

import java.util.List;

public interface EquiposService {
     List<Equipo> getEquipos();
     Equipo getEquiposById(Integer id);
     List<Equipo> getEquiposByIdMedico(String idMedico);
     Equipo getEquiposByIdPaciente(String id);
}
