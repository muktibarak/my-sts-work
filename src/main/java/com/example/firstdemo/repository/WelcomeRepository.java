package com.example.firstdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.firstdemo.model.Persona;

public interface WelcomeRepository extends JpaRepository<Persona, Integer> {
	
}
