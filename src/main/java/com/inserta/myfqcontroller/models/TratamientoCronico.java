package com.inserta.myfqcontroller.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tratamientos_cronicos")
public class TratamientoCronico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String dniPaciente;
    private String descripcion;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;
    private String archivo;
    private boolean oral;
    private boolean inhalado;


}
