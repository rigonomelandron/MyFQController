package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Deporte;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface DeportesService {

     List<Deporte> listado();
     Deporte deporteById(int id);
     List<Deporte> deportesByDni(String dni);
     List<Deporte> deportesByDniFecha(String dni, Date fecha);
     List<Deporte> deportesByIdUsuarioFecha(int idUsuario, Date fecha);
     Deporte addDeporte(Deporte deporte);


}
