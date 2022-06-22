package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Analitica;

import java.util.Date;
import java.util.List;

public interface AnaliticasService {
    public List<Analitica> getAnaliticas();
    public Analitica getAnaliticasById(Integer id);
    public List<Analitica> getAnaliticasByDni(String dni);
    public List<Analitica> getAnaliticasByDniAndFecha(String dni, Date fecha);
    public List<Analitica> getAnaliticasByIdUsuarioFecha(String idUsuario, Date fecha);

}
