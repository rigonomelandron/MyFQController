package com.inserta.myfqcontroller.controllers;

import com.inserta.myfqcontroller.models.Mensaje;
import com.inserta.myfqcontroller.services.MensajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin(origins = "*")

public class MensajesController {
    @Autowired
    private MensajesService mensajesService;


    @RequestMapping("/mensajes/listado")
    public List<Mensaje> listadoMensajes (){
        return mensajesService.getMensajes();
    }
    @PostMapping("/mensaje/crear")
    public Mensaje crearMensaje(@RequestBody Mensaje mensaje){
        return mensajesService.crearMensaje(mensaje);
    }
    @RequestMapping("/mensajes/id/{id}")
    public Mensaje mensajeById(@PathVariable int id){
        return mensajesService.getMensajeById(id);
    }
    @RequestMapping("/mensajes/idPaciente/{idPaciente}")
    public List<Mensaje> mensajesByIDPaciente(@PathVariable String idPaciente){
        return mensajesService.getMensajesByIdPaciente(idPaciente);
    }
    @RequestMapping("/mensajes/idPacienteFecha/{idPaciente}/{fecha}")
    public List<Mensaje> mensajesByIDPacienteFecha(@PathVariable String idPaciente, @PathVariable Date fecha) {
        // Date date =new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        return mensajesService.getMensajesByIdPacienteAndFecha(idPaciente,fecha);
    }
    @RequestMapping("/mensajes/idMedico/{idMedico}")
    public List<Mensaje> mensajesByIDMedico(@PathVariable String idMedico){
        return mensajesService.getMensajesByIdMedico(idMedico);
    }
    @RequestMapping("/mensajes/idMedicoFecha/{idMedico}/{fecha}")
    public List<Mensaje> mensajesByIDMedicoFecha(@PathVariable String idMedico, @PathVariable Date fecha)  {
        //Date date =new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        return mensajesService.getMensajesByIdMedicoAndFecha(idMedico,fecha);
    }
    @PatchMapping("/mensaje/modificar")
    public Mensaje modificarMensaje(@RequestBody Mensaje mensaje){
        return mensajesService.modificarMensaje(mensaje);
    }
    @RequestMapping("/mensaje/noVisto/{idPaciente}/{visto}")
    public List<Mensaje> mensajesByIDPacienteVisto(@PathVariable String idPaciente, @PathVariable boolean visto) {
        return mensajesService.getMensajesByIdPacienteAndIsVisto(idPaciente,visto);
    }
}
