package com.inserta.myfqcontroller.services;




import com.inserta.myfqcontroller.models.TratamientoCronico;

import java.time.LocalDateTime;
import java.util.List;

public interface TratamientosCronicosService {

    public List<TratamientoCronico> listado();
    public TratamientoCronico tratamientoById(int id);
    public List<TratamientoCronico> tratamientoByDni(String dni);
    public List<TratamientoCronico> tratamientoByDniFecha(String dni, LocalDateTime fecha);
}
