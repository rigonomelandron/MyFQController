package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Antecedente;
import com.inserta.myfqcontroller.models.CicloAntibiotico;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface AntecedentesService {

     Antecedente getAntecedenteById(Integer id);
     List<Antecedente> getAntecedentes();
     List<Antecedente> getAntecedentesByDni(String dni);
     List<Antecedente> getAntecedentesByDniAndFecha(String dni, Date fecha);
     List<Antecedente> getAntecedentesByIdUsuarioAndFecha(String idUsuario, Date fecha);

}
