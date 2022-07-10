package com.inserta.myfqcontroller.services;


import com.inserta.myfqcontroller.models.TratamientoCronico;
import com.inserta.myfqcontroller.repos.TratamientosCronicosRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class TratamientosCronicosServicesImpl implements TratamientosCronicosService{
    @Autowired
    private TratamientosCronicosRepos tratamientosCronicosRepos;
    @Override
    public List<TratamientoCronico> listado() {
        return tratamientosCronicosRepos.findAll();
    }

    @Override
    public TratamientoCronico tratamientoById(int id) {
        return tratamientosCronicosRepos.findById(id).orElse(null);
    }

    @Override
    public List<TratamientoCronico> tratamientoByDni(String dni) {
        return tratamientosCronicosRepos.findByPaciente_Dni(dni);
    }

    @Override
    public List<TratamientoCronico> tratamientoByDniFecha(String dni, Date fecha) {
        return tratamientosCronicosRepos.findByPaciente_DniAndFecha(dni,fecha);
    }

    @Override
    public List<TratamientoCronico> tratamientoByIdUsuarioFecha(int idUsuario, Date fechaInicio) {
        return tratamientosCronicosRepos.findByPaciente_idUsuarioAndFecha(idUsuario,fechaInicio);
    }

    @Override
    public TratamientoCronico crearTratamientoCronico(TratamientoCronico tratamientoCronico) {
        return tratamientosCronicosRepos.save(tratamientoCronico);
    }
}
