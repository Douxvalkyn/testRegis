package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Prenom;
import com.example.repositories.PrenomRepository;

@RestController
@RequestMapping(path="prenom")
public class PrenomResource {

	static Logger mainLog = LoggerFactory.getLogger(PrenomResource.class);
	@Autowired
	protected PrenomRepository prenomRepository;
	
	@GetMapping(path="all", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Prenom> searchAll(){
		Iterable<Prenom> prenoms = prenomRepository.findAll();
		List<Prenom> results = new ArrayList<Prenom>();
		for (Prenom p:prenoms) {
			results.add(p);
		}
	  mainLog.info("nb prenoms " + results.size());
		
		return results;
	}
	
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Prenom> createPrenom(@RequestBody Prenom prenom){
		Prenom managePrenom = prenomRepository.save(prenom);
		return ResponseEntity.ok(managePrenom);
	}
	
	
}
