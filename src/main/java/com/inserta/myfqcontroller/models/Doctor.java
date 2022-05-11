package com.inserta.myfqcontroller.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctores")
public class Doctor {
    @Id
    private String numColegiado;

    @Column(nullable = false)
    private String nombre;
    private String email;

    private String id_usuario;


}
