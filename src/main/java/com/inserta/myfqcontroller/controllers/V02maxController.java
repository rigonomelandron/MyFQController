package com.inserta.myfqcontroller.controllers;


import com.inserta.myfqcontroller.models.Deporte;
import com.inserta.myfqcontroller.models.V02max;
import com.inserta.myfqcontroller.services.DeportesService;
import com.inserta.myfqcontroller.services.V02maxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1")
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

    public List<V02max> deporteByUserFecha(@PathVariable String dni, @PathVariable LocalDateTime fecha){
        return v02maxService.tensionByDniFecha(dni, fecha);
    }
}
