package com.rosales.exception;

/*
 * Exception personalizada de status 200 para filme que já existe
 * */

public class FilmeExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public static final String DESCRIPTION = "Filme já existe";
	
	public FilmeExistException(String erro) {
		super(DESCRIPTION + ": " + erro);
	}

}
