package com.inserta.myfqcontroller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tension")
public class Tension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dni_paciente", referencedColumnName = "dni")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Paciente paciente;
    @Column(nullable = true)
    private int maxTension;
    @Column(nullable = true)
    private int minTension;

    public Tension(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getMaxTension() {
        return maxTension;
    }

    public void setMaxTension(int maxTension) {
        this.maxTension = maxTension;
    }

    public int getMinTension() {
        return minTension;
    }

    public void setMinTension(int minTension) {
        this.minTension = minTension;
    }
}
