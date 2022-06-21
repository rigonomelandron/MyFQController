package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.DatoRespiratorio;
import com.inserta.myfqcontroller.models.Paciente;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface DatosRespiratoriosService {
    public List<DatoRespiratorio> getDatosRespiratorios();
    public List<DatoRespiratorio> getDatosRespiratoriosByDni(String dni);
    public List<DatoRespiratorio> getDatosRespiratoriosByDniAndFecha(String dni, Date fecha);
    public DatoRespiratorio getDatoRespiratorioById(Integer id);
    public List<DatoRespiratorio> findAllByFechaBetween(Date desde, Date hasta);


    public List<DatoRespiratorio> findAllByPacienteIdUsuarioFecha(String idUsuario, Date fecha) ;
}
