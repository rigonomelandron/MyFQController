package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Equipo;

import java.util.List;

public interface EquiposService {
    public List<Equipo> getEquipos();
    public Equipo getEquiposById(Integer id);
    public List<Equipo> getEquiposByIdMedico(String idMedico);
}
