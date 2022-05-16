package com.inserta.myfqcontroller.services;




import com.inserta.myfqcontroller.models.V02max;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface V02maxService {

    public List<V02max> listado();
    public V02max tensionById(int id);
    public List<V02max> tensionByDni(String dni);
    public List<V02max> tensionByDniFecha(String dni, Date fecha);
}
