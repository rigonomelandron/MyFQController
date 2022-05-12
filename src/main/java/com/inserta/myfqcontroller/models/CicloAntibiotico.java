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
@Table(name = "ciclos_antibioticos")
public class CicloAntibiotico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String dniPaciente;
    String antibiotico;
    boolean esIntravenoso;
    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime fechaInicio;
    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime fechaFin;
}
