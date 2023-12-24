package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String specialization;
	    private String PhoneNumber;
	    private String availability;
		public Doctor() {
			super();
		}
		public Doctor(Long id, String name, String specialization, String phoneNumber, String availability) {
			super();
			this.id = id;
			this.name = name;
			this.specialization = specialization;
			this.PhoneNumber = phoneNumber;
			this.availability = availability;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSpecialization() {
			return specialization;
		}
		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}
		public String getPhoneNumber() {
			return PhoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.PhoneNumber = phoneNumber;
		}
		public String getAvailability() {
			return availability;
		}
		public void setAvailability(String availability) {
			this.availability = availability;
		}
		@Override
		public String toString() {
			return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", PhoneNumber="
					+ PhoneNumber + ", availability=" + availability + "]";
		}
		
}
