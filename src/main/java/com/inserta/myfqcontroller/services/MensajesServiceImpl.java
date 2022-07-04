package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Mensaje;
import com.inserta.myfqcontroller.repos.MensajesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class MensajesServiceImpl implements MensajesService {
    @Autowired
    private MensajesRepo mensajesRepo;

    @Override
    public Mensaje crearMensaje(Mensaje mensaje) {
        return mensajesRepo.save(mensaje);
    }

    @Override
    public List<Mensaje> getMensajes() {
        return mensajesRepo.findAll();
    }

    @Override
    public Mensaje getMensajeById(Integer id) {
        return mensajesRepo.findById(id).orElse(null);
    }

    @Override
    public List<Mensaje> getMensajesByIdPaciente(String idPaciente) {
        return mensajesRepo.findAllByIdPaciente(idPaciente);
    }

    @Override
    public List<Mensaje> getMensajesByIdMedico(String idMedico) {
        return mensajesRepo.findAllByIdMedico(idMedico);
    }

    @Override
    public List<Mensaje> getMensajesByIdPacienteAndFecha(String idPaciente, Date fecha) {
        return mensajesRepo.findAllByIdPacienteAndFecha(idPaciente, fecha);
    }

    @Override
    public List<Mensaje> getMensajesByIdMedicoAndFecha(String idMedico, Date fecha) {
        return mensajesRepo.findAllByIdMedicoAndFecha(idMedico, fecha);
    }

    @Override
    public Mensaje modificarMensaje(Mensaje mensaje) {
        return mensajesRepo.save(mensaje);
    }

    @Override
    public List<Mensaje> getMensajesByIdPacienteAndIsVisto(String idPaciente, boolean visto) {
        return mensajesRepo.findAllByIdPacienteAndIsVisto(idPaciente, visto);
    }


}

