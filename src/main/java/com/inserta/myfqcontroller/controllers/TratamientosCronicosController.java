package com.inserta.myfqcontroller.controllers;



import com.inserta.myfqcontroller.models.Analitica;
import com.inserta.myfqcontroller.models.TratamientoCronico;
import com.inserta.myfqcontroller.services.TratamientosCronicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.UUID;

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
    @PostMapping("/tratamiento")
    public TratamientoCronico nuevoTratamiento(@RequestBody TratamientoCronico tratamientoCronico) {
        return tratamientosCronicosService.crearTratamientoCronico(tratamientoCronico);
    }
    @PostMapping("/tratamiento/upload")
    public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Integer id) throws IOException {
        Map<String, Object> response = new HashMap<>();


        TratamientoCronico  tratamiento = (TratamientoCronico) tratamientosCronicosService.tratamientoById(id);
        if(!archivo.isEmpty()) {
            String nombreArchivo = UUID.randomUUID().toString() + "_" +  archivo.getOriginalFilename().replace(" ", "");

            Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
            //log.info("rutaArchivo: " + rutaArchivo);

            System.out.println("rutaArchivo: " + rutaArchivo);
            try {
                Files.copy(archivo.getInputStream(), rutaArchivo);
            } catch (IOException e) {
                response.put("mensaje", "Error al subir la imagen del cliente " + nombreArchivo);
                response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String nombreArchivoAnterior = tratamiento.getArchivo();

            if(nombreArchivoAnterior !=null && nombreArchivoAnterior.length() >0) {
                Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreArchivoAnterior).toAbsolutePath();
                File archivoFotoAnterior = rutaFotoAnterior.toFile();
                if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
                    archivoFotoAnterior.delete();
                }
            }

            tratamiento.setArchivo(nombreArchivo);
            tratamientosCronicosService.crearTratamientoCronico(tratamiento);
            response.put("mensaje", "Has subido correctamente el archivo: " + nombreArchivo);



        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    @GetMapping("/uploads/archivo/{nombreArchivo:.+}")
    public ResponseEntity<Resource> verArchivo(@PathVariable String nombreArchivo){

        Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
        //log.info(rutaArchivo.toString());

        Resource recurso = null;

        try {
            recurso = new UrlResource(rutaArchivo.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if(!recurso.exists() && !recurso.isReadable()) {
            throw new RuntimeException("Error no se pudo cargar la imagen: " + nombreArchivo);
        }
        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

        return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
    }


}
