package com.inserta.myfqcontroller.services;


import com.inserta.myfqcontroller.models.TratamientoCronico;
import com.inserta.myfqcontroller.repos.TratamientosCronicosRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        return tratamientosCronicosRepos.findByDniPaciente(dni);
    }

    @Override
    public List<TratamientoCronico> tratamientoByDniFecha(String dni, LocalDateTime fecha) {
        return tratamientosCronicosRepos.findByDniPacienteAndFecha(dni,fecha);
    }
}
