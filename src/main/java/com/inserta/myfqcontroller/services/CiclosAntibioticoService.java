package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.CicloAntibiotico;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface CiclosAntibioticoService {

     List<CicloAntibiotico> getCiclosAntibiotico();
     List<CicloAntibiotico> getCiclosAntibioticoByDni(String dni);
     List<CicloAntibiotico> getCiclosAntibioticoByDniAndFechaInicio(String dni, Date fecha);
     List<CicloAntibiotico> getCiclosAntibioticoByEsIntravenosoTrue();
     CicloAntibiotico getCiclosAntibioticoById(Integer id);
     List<CicloAntibiotico> getCiclosAntibioticoByPaciente_IdUsuarioAndFechaInicio(String dni, Date fecha);
     CicloAntibiotico addCiclosAntibiotico(CicloAntibiotico cicloAntibiotico);


}
