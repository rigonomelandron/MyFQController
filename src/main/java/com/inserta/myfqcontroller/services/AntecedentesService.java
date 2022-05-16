package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Antecedente;
import com.inserta.myfqcontroller.models.CicloAntibiotico;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface AntecedentesService {

    public Antecedente getAntecedenteById(Integer id);
    public List<Antecedente> getAntecedentes();
    public List<Antecedente> getAntecedentesByDni(String dni);
    public List<Antecedente> getAntecedentesByDniAndFecha(String dni, Date fecha);


}
