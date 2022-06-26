package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Analitica;

import java.util.Date;
import java.util.List;

public interface AnaliticasService {
     List<Analitica> getAnaliticas();
     Analitica getAnaliticasById(Integer id);
     List<Analitica> getAnaliticasByDni(String dni);
     List<Analitica> getAnaliticasByDniAndFecha(String dni, Date fecha);
     List<Analitica> getAnaliticasByIdUsuarioFecha(String idUsuario, Date fecha);
        Analitica crearAnalitica(Analitica analitica);

}
