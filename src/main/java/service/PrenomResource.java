package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Prenom;
import repositories.PrenomRepository;

@RestController
@RequestMapping(path="prenom")
public class PrenomResource {

	@Autowired
	protected PrenomRepository prenomRepository;
	
	@GetMapping(path="all")
	public List<Prenom> searchAll(){
		Iterable<Prenom> prenoms = prenomRepository.findAll();
		List<Prenom> results = new ArrayList<Prenom>();
		for (Prenom p:prenoms) {
			results.add(p);
		}
		
		return results;
	}
	
	
}
