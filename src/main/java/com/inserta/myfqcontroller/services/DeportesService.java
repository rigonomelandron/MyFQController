package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Deporte;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface DeportesService {

    public List<Deporte> listado();
    public Deporte deporteById(int id);
    public List<Deporte> deportesByDni(String dni);
    public List<Deporte> deportesByDniFecha(String dni, Date fecha);
}
