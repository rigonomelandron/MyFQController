package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.DatoRespiratorio;

import java.time.LocalDateTime;
import java.util.List;

public interface DatosRespiratoriosService {
    public List<DatoRespiratorio> getDatosRespiratorios();
    public List<DatoRespiratorio> getDatosRespiratoriosByDni(String dni);
    public List<DatoRespiratorio> getDatosRespiratoriosByDniAndFecha(String dni, LocalDateTime fecha);
    public DatoRespiratorio getDatoRespiratorioById(Integer id);
}
