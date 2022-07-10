package com.inserta.myfqcontroller.services;

import com.inserta.myfqcontroller.models.Doctor;
import com.inserta.myfqcontroller.repos.DoctoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctoresServiceImpl implements DoctoresService{
    @Autowired
    DoctoresRepo doctoresRepo;
    @Override
    public List<Doctor> getDoctores() {
        return doctoresRepo.findAll();
    }

    @Override
    public Doctor getDoctorByNumColegiado(String numColegiado) {
        return doctoresRepo.findByNumColegiado(numColegiado);
    }

    @Override
    public Doctor getDoctorByIdUsuario(int idUsuario) {
        return doctoresRepo.findByIdUsuario(idUsuario);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctoresRepo.save(doctor);
    }

    @Override
    public Doctor modificarDoctor(Doctor doctor) {
        return doctoresRepo.save(doctor);
    }

    @Override
    public Doctor deleteDoctor( String colegiado) {
        return doctoresRepo.deleteByNumColegiado(colegiado);
    }

}
