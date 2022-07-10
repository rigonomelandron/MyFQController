package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Paciente;

import java.util.List;

public interface PacientesService {
     List<Paciente> getPacientes();
     Paciente getPacienteByDni(String dni);
     Paciente getPacienteByIdUsuario(int username);
     Paciente crearPaciente(Paciente paciente);
     Paciente modificarPaciente( Paciente paciente);
}
