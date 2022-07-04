package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Mensaje;

import java.util.Date;
import java.util.List;

public interface MensajesService {
    Mensaje crearMensaje(Mensaje mensaje);
    List<Mensaje> getMensajes();
    Mensaje getMensajeById(Integer id);
    List<Mensaje> getMensajesByIdPaciente(String idPaciente);
    List<Mensaje> getMensajesByIdMedico(String idMedico);
    List<Mensaje> getMensajesByIdPacienteAndFecha(String idPaciente, Date fecha);
    List<Mensaje> getMensajesByIdMedicoAndFecha(String idPMedico, Date fecha);
    Mensaje modificarMensaje(Mensaje mensaje);
    List<Mensaje> getMensajesByIdPacienteAndIsVisto(String idPaciente, boolean visto);

}
