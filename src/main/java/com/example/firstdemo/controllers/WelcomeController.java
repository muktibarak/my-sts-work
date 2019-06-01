package com.example.firstdemo.controllers;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstdemo.repository.WelcomeRepository;

import com.example.firstdemo.model.Persona;
@CrossOrigin ("*")
// * or http://localhost:4200
@RestController
@RequestMapping("/welcome")
public class WelcomeController {
	
	@Autowired
	WelcomeRepository welcomeReposirtoy;
	
	@GetMapping
	@RequestMapping("/getName/{id}")
	public Optional<Persona> getValue(@PathVariable int id) {
		//System.out.println("id: "+id);
		return welcomeReposirtoy.findById(id);
	}
	
	
	@GetMapping
	@RequestMapping("/getNames") 
	public List<Persona> getValue() {
		return welcomeReposirtoy.findAll();
	}
	
	@PostMapping
	@RequestMapping("/postName")
		public String postName(@RequestBody Persona persona) {
		//System.out.println("username " + persona.getUsername());
		welcomeReposirtoy.save(persona);
		return "This is a post name.";
	}
	
	@PutMapping
	@RequestMapping("/putName/{id}")
		public String putName(@RequestBody Persona persona, @PathVariable int id) {
		//System.out.println("id: "+ id);
		//System.out.println("status: " + persona.getStatus());
		welcomeReposirtoy.save(persona);
		//return "This name is updated.";
		return "updated";
		
	}
	
	@DeleteMapping
	@RequestMapping("/deleteName/{id}")
		public String deleteName(@PathVariable int id) {
		welcomeReposirtoy.deleteById(id);
		return "This name is deleted.";
	}
}

