package com.rosales.exception;

/*
 * Exception personalizada de status 422
 * */

public class FilmeUnprocessableException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public FilmeUnprocessableException(String erro) {
		super(erro);
	}
	
}
