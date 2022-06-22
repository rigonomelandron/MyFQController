package com.inserta.myfqcontroller.services;




import com.inserta.myfqcontroller.models.V02max;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface V02maxService {

    List<V02max> listado();
    V02max tensionById(int id);
    List<V02max> tensionByDni(String dni);
    List<V02max> tensionByDniFecha(String dni, Date fecha);
    List<V02max> tensionByIdUsuarioFecha(String idUsuario, Date fecha);
}
