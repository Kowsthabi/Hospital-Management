package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}