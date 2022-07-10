package com.inserta.myfqcontroller.dto;

import com.inserta.myfqcontroller.models.Rol;
import com.inserta.myfqcontroller.security.enums.RolNombre;
import com.inserta.myfqcontroller.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        /*Rol paciente = new Rol(RolNombre.ROLE_PACIENTE);
        Rol medico= new Rol(RolNombre.ROLE_MEDICO);
        rolService.save(paciente);
        rolService.save(medico);*/

    }
}
