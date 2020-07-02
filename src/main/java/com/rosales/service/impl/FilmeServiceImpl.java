package com.rosales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosales.model.Filme;
import com.rosales.repository.IFilmeRepo;
import com.rosales.service.IFilmeService;
import com.rosales.validator.IFilmeValidator;

@Service
public class FilmeServiceImpl implements IFilmeService {

	
	@Autowired
	private IFilmeRepo repo;
	
	@Autowired
	private IFilmeValidator filmeValidator;
	
	@Override
	public Filme criar(Filme f) {
		
		filmeValidator.Validator(f);
		
		f.getElenco().forEach(e -> {
			e.setFilme(f);
		});
		
		return repo.save(f);
	}

	@Override
	public List<Filme> listarPorCensura(boolean c) {		
		return repo.findByCensurado(c);	
	}

	@Override
	public Filme buscarFilme(String filme) {
		return repo.findByNome(filme);
	}	

}
