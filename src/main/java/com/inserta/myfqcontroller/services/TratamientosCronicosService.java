package com.inserta.myfqcontroller.services;




import com.inserta.myfqcontroller.models.TratamientoCronico;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TratamientosCronicosService {

    List<TratamientoCronico> listado();
    TratamientoCronico tratamientoById(int id);
    List<TratamientoCronico> tratamientoByDni(String dni);
    List<TratamientoCronico> tratamientoByDniFecha(String dni, Date fecha);
    List<TratamientoCronico> tratamientoByIdUsuarioFecha(int idUsuario, Date fechaInicio);
    TratamientoCronico crearTratamientoCronico(TratamientoCronico tratamientoCronico);
}
