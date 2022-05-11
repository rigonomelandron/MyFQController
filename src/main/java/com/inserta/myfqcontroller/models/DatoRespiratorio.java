package com.inserta.myfqcontroller.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "datosrespiratorios")
public class DatoRespiratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime fecha;
    String dniPaciente;
    float fvc;
    float fev;
    float saturacionBasal;
    float capacidadAerobica;


}
