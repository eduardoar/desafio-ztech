package com.rosales.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosales.exception.ActorNumberExceededException;
import com.rosales.exception.FilmeExistException;
import com.rosales.exception.FilmeUnprocessableException;
import com.rosales.model.Filme;
import com.rosales.service.IFilmeService;
import com.rosales.validator.IFilmeValidator;

@Service
public class FilmeValidatorImpl implements IFilmeValidator {

	@Autowired
	private IFilmeService service;
	
	Filme fil;
	
	@Override
	public void Validator(Filme filme) {
		
		if(filme.getNome() == null || filme.getNome().isEmpty()) {
			throw new FilmeUnprocessableException("O nome do filme é obrigatorio");
		}
		
		fil = service.buscarFilme(filme.getNome());		
		if(fil != null) {
			throw new FilmeExistException(fil.getNome());			
		}	
		
		if(filme.getElenco().size() > 10) {
			throw new ActorNumberExceededException("Um filme nao pode ter mais do que 10 atores");	
		}
		
	}	
	
}
