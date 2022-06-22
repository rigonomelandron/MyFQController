package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.V02max;
import com.inserta.myfqcontroller.repos.V02maxRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class V02maxServicesImpl implements  V02maxService{
    @Autowired
    private V02maxRepos v02maxRepos;
    @Override
    public List<V02max> listado() {
        return v02maxRepos.findAll() ;
    }

    @Override
    public V02max tensionById(int id) {
        return v02maxRepos.findById(id).orElse(null);
    }

    @Override
    public List<V02max> tensionByDni(String dni) {
        return v02maxRepos.findByPaciente_Dni(dni);
    }

    @Override
    public List<V02max> tensionByDniFecha(String dni, Date fecha) {
        return v02maxRepos.findByPaciente_DniAndFecha(dni, fecha);
    }

    @Override
    public List<V02max> tensionByIdUsuarioFecha(String idUsuario, Date fecha) {
        return v02maxRepos.findByPaciente_IdUsuarioAndFecha(idUsuario, fecha);
    }
}
