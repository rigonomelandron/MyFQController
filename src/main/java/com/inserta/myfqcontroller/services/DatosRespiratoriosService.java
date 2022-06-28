package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.DatoRespiratorio;
import com.inserta.myfqcontroller.models.Paciente;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface DatosRespiratoriosService {
     List<DatoRespiratorio> getDatosRespiratorios();
     List<DatoRespiratorio> getDatosRespiratoriosByDni(String dni);
     List<DatoRespiratorio> getDatosRespiratoriosByDniAndFecha(String dni, Date fecha);
     DatoRespiratorio getDatoRespiratorioById(Integer id);
     List<DatoRespiratorio> findAllByFechaBetween(String idUsuario, Date desde, Date hasta);
     List<DatoRespiratorio> findAllByPacienteIdUsuarioFecha(String idUsuario, Date fecha) ;

     DatoRespiratorio crearDatoRespiratorio(DatoRespiratorio datoRespiratorio);
     List<DatoRespiratorio> getByIdUsuario(String idUsuario);

}
