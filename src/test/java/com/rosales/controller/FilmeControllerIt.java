package com.rosales.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rosales.model.Ator;
import com.rosales.model.Filme;
import com.rosales.service.IFilmeService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class FilmeControllerIt {
	
	private static final String name1 = "Avengers Infitny War";
	private static final String name2 = "Avengers End Game";
	private static final String name3 = "Civil War";
	private static final LocalDate data = LocalDate.parse("2020-06-30");
	private static final boolean censored = true;
	private static final boolean n_censored = false;
	private static final String director = "Joe Russo";
	
	@Autowired
	private IFilmeService filmeService;	
	
	
	@Test
    @Order(1) 
    public void testFilmeCreateCensoredAndSearch() {
    	List<Ator> lstActor = new ArrayList<>();    	
    	Filme filme = new Filme();
    	filme.setNome(name1);
		filme.setDataLancamento(data);
		filme.setCensurado(censored);
		filme.setDirecao(director);
		lstActor.add(new Ator("Chris", filme));
		filme.setElenco(lstActor);
    	
        Filme filmeRetorno = filmeService.criar(filme);
        assertThat(filmeRetorno.getNome(), equalTo(filme.getNome()));
        
        List<Filme> lstFilme = filmeService.listarPorCensura(true);        
        assertThat(lstFilme.size(), equalTo(1));
    }
	
	@Test
    @Order(2) 
    public void testFilmeCreateNotCensoredAndSearch() {
    	List<Ator> lstActor = new ArrayList<>();    	
    	Filme filme = new Filme();
    	filme.setNome(name2);
		filme.setDataLancamento(data);
		filme.setCensurado(n_censored);
		filme.setDirecao(director);
		lstActor.add(new Ator("Chris", filme));
		filme.setElenco(lstActor);
    	
        Filme filmeRetorno = filmeService.criar(filme);
        assertThat(filmeRetorno.getNome(), equalTo(filme.getNome()));
        
        List<Filme> lstFilme = filmeService.listarPorCensura(false);        
        assertThat(lstFilme.size(), equalTo(1));
    }
	
	@Test
    @Order(3) 
    public void testFilmeCreateTenActors() {
		List<Ator> lstActor = new ArrayList<>();    		
    	Filme filme = new Filme();
    	filme.setNome(name3);
		filme.setDataLancamento(data);
		filme.setCensurado(censored);
		filme.setDirecao(director);
		lstActor = Arrays.asList(new Ator("Chris", filme), new Ator("Chris", filme), new Ator("Chris", filme),new Ator("Chris", filme), new Ator("Chris", filme), new Ator("Chris", filme), new Ator("Chris", filme), new Ator("Chris", filme), new Ator("Chris", filme), new Ator("Chris", filme));
		filme.setElenco(lstActor);
    	
        Filme filmeRetorno = filmeService.criar(filme);
        assertThat(filmeRetorno.getNome(), equalTo(filme.getNome()));
        
        List<Filme> lstFilme = filmeService.listarPorCensura(true);        
        assertThat(lstFilme.size(), equalTo(2));
    }

}
