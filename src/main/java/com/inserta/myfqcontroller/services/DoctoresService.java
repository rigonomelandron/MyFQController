package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Doctor;

import java.util.List;

public interface DoctoresService {
    public List<Doctor> getDoctores();
    public Doctor getDoctorByNumColegiado(String numColegiado);

}
