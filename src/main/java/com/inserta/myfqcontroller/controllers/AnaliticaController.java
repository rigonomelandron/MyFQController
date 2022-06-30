package com.inserta.myfqcontroller.controllers;


import com.inserta.myfqcontroller.models.Analitica;
import com.inserta.myfqcontroller.services.AnaliticasService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;


@RequestMapping("/api/v1")
@RestController
public class AnaliticaController {
    @Autowired
    private AnaliticasService analiticasService;

    @GetMapping("/analiticas/listado")
    public List<Analitica> listadoAnaliticas (){
        return analiticasService.getAnaliticas();
    }

    @GetMapping("/analiticas/id/{id}")
    public Analitica analiticaById(@PathVariable int id){
        return analiticasService.getAnaliticasById(id);
    }

    @GetMapping("/analiticas/dni/{dni}")
    public List<Analitica> analiticasByDni(@PathVariable String dni){
        return analiticasService.getAnaliticasByDni(dni);

    }

    @GetMapping("/analiticas/dniFecha/{dni}/{fecha}")

    public List<Analitica> analiticasByUserFecha(@PathVariable String dni, @PathVariable String fecha) throws ParseException {

        Date date =new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        return analiticasService.getAnaliticasByDniAndFecha(dni, date);
    }
    @GetMapping("/analiticas/idUsuarioFecha/{idUsuario}/{fecha}")
    public List<Analitica> analiticasByIdUsuarioFecha(@PathVariable String idUsuario, @PathVariable Date fecha) {
        return analiticasService.getAnaliticasByIdUsuarioFecha(idUsuario, fecha);
    }

    @PostMapping("/analiticas")
    public Analitica createAnalitica(@RequestBody Analitica analitica){
        return analiticasService.crearAnalitica(analitica);
    }
    @PostMapping("/analitica/upload")
    public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Integer id) throws IOException {
        Map<String, Object> response = new HashMap<>();


        Analitica analitica = (Analitica) analiticasService.getAnaliticasById(id);
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

            String nombreArchivoAnterior = analitica.getArchivo();

            if(nombreArchivoAnterior !=null && nombreArchivoAnterior.length() >0) {
                Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreArchivoAnterior).toAbsolutePath();
                File archivoFotoAnterior = rutaFotoAnterior.toFile();
                if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
                    archivoFotoAnterior.delete();
                }
            }

            analitica.setArchivo(nombreArchivo);
               analiticasService.crearAnalitica(analitica);
            response.put("mensaje", "Has subido correctamente el archivo: " + nombreArchivo);



        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    @GetMapping("/uploads/archivo/{nombreArchivo}")
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
