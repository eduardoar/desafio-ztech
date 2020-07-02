package com.rosales.service;

import java.util.List;

import com.rosales.model.Filme;

public interface IFilmeService {

	Filme criar(Filme f);
	
	List<Filme> listarPorCensura(boolean c);
	
	Filme buscarFilme(String filme);
	
}
