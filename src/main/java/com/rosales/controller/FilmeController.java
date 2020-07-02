package com.rosales.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rosales.model.Filme;
import com.rosales.service.IFilmeService;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeController {
	
	@Autowired
	private IFilmeService service;
	
	@PostMapping
	public ResponseEntity<Filme> criar(@RequestBody Filme filme){		
		Filme f = new Filme();	
		f = service.criar(filme);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{nome}").buildAndExpand(f.getNome()).toUri();		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/{censurado}")
	public ResponseEntity<List<Filme>> listarPorCensura(@PathVariable("censurado") boolean censura){		
		List<Filme> listaFilmes = service.listarPorCensura(censura);				
		return new ResponseEntity<List<Filme>>(listaFilmes, HttpStatus.OK);	
	}

}
