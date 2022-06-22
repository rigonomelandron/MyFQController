package com.inserta.myfqcontroller.controllers;



import com.inserta.myfqcontroller.models.TratamientoCronico;
import com.inserta.myfqcontroller.services.TratamientosCronicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TratamientosCronicosController {

    @Autowired
    private TratamientosCronicosService tratamientosCronicosService;

    @GetMapping("/tratamientos/listado")
    public List<TratamientoCronico> listadoTratamientos (){
        return tratamientosCronicosService.listado();
    }

    @GetMapping("/tratamientos/id/{id}")
    public TratamientoCronico tratamientoById(@PathVariable int id){
        return tratamientosCronicosService.tratamientoById(id);
    }

    @GetMapping("/tratamientos/dni/{dni}")
    public List<TratamientoCronico> tratamientoByDni(@PathVariable String dni){
        return tratamientosCronicosService.tratamientoByDni(dni);

    }

    @GetMapping("/tratamientos/dniFecha/{dni}/{fecha}")

    public List<TratamientoCronico> deporteByUserFecha(@PathVariable String dni, @PathVariable String fecha) throws ParseException {
        Date date =new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        return tratamientosCronicosService.tratamientoByDniFecha(dni, date);
    }

    @GetMapping("/tratamientos/idUsuario/{idUsuario}/{fechaInicio}")
    public List<TratamientoCronico> tratamientoByIdUsuarioFecha(@PathVariable String idUsuario, @PathVariable Date fechaInicio) {
        return tratamientosCronicosService.tratamientoByIdUsuarioFecha(idUsuario, fechaInicio);
    }

}
