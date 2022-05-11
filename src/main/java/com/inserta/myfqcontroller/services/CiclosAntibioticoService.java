package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.CicloAntibiotico;

import java.time.LocalDateTime;
import java.util.List;

public interface CiclosAntibioticoService {

    public List<CicloAntibiotico> getCiclosAntibiotico();
    public List<CicloAntibiotico> getCiclosAntibioticoByDni(String dni);
    public List<CicloAntibiotico> getCiclosAntibioticoByDniAndFechaInicio(String dni, LocalDateTime fecha);
    public List<CicloAntibiotico> getCiclosAntibioticoByEsIntravenosoTrue();
    public CicloAntibiotico getCiclosAntibioticoById(Integer id);


}
