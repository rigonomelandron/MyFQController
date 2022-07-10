package com.inserta.myfqcontroller.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    private String dni;
    @Column(nullable = false)
    private String nombre;
    private String email;
    private Date fechaNacimiento;
    private String genero;
    private double peso;
    private double altura;
    private String mutacion1;
    private String mutacion2;
    private int idUsuario;
}
