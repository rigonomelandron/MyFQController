package com.inserta.myfqcontroller.services;


import com.inserta.myfqcontroller.models.Tension;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TensionService {

    public List<Tension> listado();
    public Tension tensionById(int id);
    public List<Tension> tensionByDni(String dni);
    public List<Tension> tensionByDniFecha(String dni, Date fecha);

    List<Tension> findAllByFechaBetween(Date desde, Date hasta);
}
