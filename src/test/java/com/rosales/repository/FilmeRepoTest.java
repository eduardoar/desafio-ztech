package com.rosales.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rosales.model.Ator;
import com.rosales.model.Filme;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class FilmeRepoTest {
	
	private static final String name = "Avengers End Game";
	private static final LocalDate data = LocalDate.parse("2020-06-30");
	private static final boolean censored = true;
	private static final boolean n_censored = false;
	private static final String director = "Joe Russo";
	
	@Autowired
    private IFilmeRepo filmeRepo;

    @Test
    @Order(1) 
    public void testFilmeCreateCensoredAndSearch() {
    	List<Ator> lstActor = new ArrayList<>();    	
    	Filme filme = new Filme();
    	filme.setNome(name);
		filme.setDataLancamento(data);
		filme.setCensurado(censored);
		filme.setDirecao(director);
		lstActor.add(new Ator("Chris", filme));
		filme.setElenco(lstActor);
    	
        Filme filmeRetorno = filmeRepo.save(filme);
        assertThat(filmeRetorno.getNome(), equalTo(filme.getNome()));
        
        List<Filme> lstFilme = filmeRepo.findByCensurado(true);        
        assertThat(lstFilme.size(), equalTo(1));
    }
    
    @Test
    @Order(2) 
    public void testFilmeCreateNotCensoredAndSearch() {
    	List<Ator> lstActor = new ArrayList<>();    	
    	Filme filme = new Filme();
    	filme.setNome(name);
		filme.setDataLancamento(data);
		filme.setCensurado(n_censored);
		filme.setDirecao(director);
		lstActor.add(new Ator("Chris", filme));
		filme.setElenco(lstActor);
    	
        Filme filmeRetorno = filmeRepo.save(filme);
        assertThat(filmeRetorno.getNome(), equalTo(filme.getNome()));
        
        List<Filme> lstFilme = filmeRepo.findByCensurado(false);        
        assertThat(lstFilme.size(), equalTo(1));
    }
	
	
}
