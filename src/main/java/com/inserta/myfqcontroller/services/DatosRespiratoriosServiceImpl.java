package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.DatoRespiratorio;
import com.inserta.myfqcontroller.models.Paciente;
import com.inserta.myfqcontroller.repos.DatosRespiratoriosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class DatosRespiratoriosServiceImpl implements DatosRespiratoriosService{

    @Autowired
    DatosRespiratoriosRepo datosRespiratoriosRepo;

    @Override
    public List<DatoRespiratorio> getDatosRespiratorios() {
        return datosRespiratoriosRepo.findAll();
    }

    @Override
    public List<DatoRespiratorio> getDatosRespiratoriosByDni(String dni) {
        return datosRespiratoriosRepo.findByPaciente_Dni(dni);
    }

    @Override
    public List<DatoRespiratorio> getDatosRespiratoriosByDniAndFecha(String dni, Date fecha) {
        return datosRespiratoriosRepo.findByPaciente_DniAndFecha(dni, fecha);
    }

    @Override
    public DatoRespiratorio getDatoRespiratorioById(Integer id) {
        return datosRespiratoriosRepo.findById(id).orElse(null);
    }

    @Override
    public List<DatoRespiratorio> findAllByFechaBetween(Date desde, Date hasta) {
        return datosRespiratoriosRepo.findAllByFechaBetween(desde, hasta);
    }

    @Override
    public List<DatoRespiratorio> findAllByPacienteIdUsuarioFecha(String idUsuario, Date fecha) {

        return datosRespiratoriosRepo.findAllByPaciente_IdUsuarioEqualsAndFecha(idUsuario, fecha);
    }



}
