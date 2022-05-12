package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Paciente;

import java.util.List;

public interface PacientesService {
    public List<Paciente> getPacientes();
    public Paciente getPacienteByDni(String dni);
}
