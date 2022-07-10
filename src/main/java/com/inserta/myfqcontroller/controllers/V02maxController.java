package com.inserta.myfqcontroller.controllers;


import com.inserta.myfqcontroller.models.Deporte;
import com.inserta.myfqcontroller.models.V02max;
import com.inserta.myfqcontroller.services.DeportesService;
import com.inserta.myfqcontroller.services.V02maxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
public class V02maxController {

    @Autowired
    private V02maxService v02maxService;

    @GetMapping("/v02max/listado")
    public List<V02max> listadoDeporte (){
        return v02maxService.listado();
    }

    @GetMapping("/v02max/id/{id}")
    public V02max deporteById(@PathVariable int id){
        return v02maxService.tensionById(id);
    }

    @GetMapping("/v02max/dni/{dni}")
    public List<V02max> deporteByDni(@PathVariable String dni){
        return v02maxService.tensionByDni(dni);

    }

    @GetMapping("/v02max/dniFecha/{dni}/{fecha}")

    public List<V02max> deporteByUserFecha(@PathVariable String dni, @PathVariable String fecha) throws ParseException {
        Date date =new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        return v02maxService.tensionByDniFecha(dni, date);
    }

    @GetMapping("/v02max/idUsuario/{idUsuario}/{fecha}")
    public List<V02max> deporteByIdUsuarioFecha(@PathVariable Integer idUsuario, @PathVariable Date fecha) {

        return v02maxService.tensionByIdUsuarioFecha(idUsuario, fecha);
    }
}
