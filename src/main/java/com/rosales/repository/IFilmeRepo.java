package com.rosales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosales.model.Filme;

public interface IFilmeRepo extends JpaRepository<Filme, String>{

	List<Filme> findByCensurado(boolean censurado);
	Filme findByNome(String filme);
	
}
