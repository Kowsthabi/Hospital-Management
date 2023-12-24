package com.example.demo.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Appointment;
import com.example.demo.Model.Patient;
import com.example.demo.Repository.AppointmentRepository;
import com.example.demo.Repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment createAppointment(Appointment appointment) {
        // Assuming that patientId and doctorId are available in the Appointment object
        Long patientId = appointment.getPatient().getId();
        Long doctorId = appointment.getDoctor().getId();

        // Retrieve the Patient and Doctor entities using their IDs
        Patient patient = getPatientById(patientId);
        // Similar logic for retrieving the Doctor entity

        // Set the retrieved entities in the Appointment object
        appointment.setPatient(patient);
        // Set the Doctor entity in the Appointment object

        // Save the Appointment object
        return appointmentRepository.save(appointment);
    }

    // Method to get a Patient by ID, handling EntityNotFoundException
    private Patient getPatientById(Long patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            throw new EntityNotFoundException("Patient not found with id: " + patientId);
        }
    }

    // Method to get an Appointment by ID, handling EntityNotFoundException
    public Appointment getAppointmentById(Long appointmentId) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        if (optionalAppointment.isPresent()) {
            return optionalAppointment.get();
        } else {
            throw new EntityNotFoundException("Appointment not found with id: " + appointmentId);
        }
    }
    
    // Additional service methods
}
