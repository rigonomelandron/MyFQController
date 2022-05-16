package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Glicada;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface GlicadasService {
    public List<Glicada> getGlicadas();
    public Glicada getGlicadasById(Integer id);
    public List<Glicada> getGlicadasByDni(String dni);
    public List<Glicada> getGlicadasByDniAndFecha(String dni, Date fecha);

}
