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
@Table(name = "glicadas")
public class Glicada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TIMESTAMP")
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "dni_paciente", referencedColumnName = "dni")
    private Paciente paciente;
    private double glicada;
}
