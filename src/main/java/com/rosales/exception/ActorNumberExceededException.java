package com.rosales.exception;

/*
 * Exception personalizada de status 422
 * */

public class ActorNumberExceededException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ActorNumberExceededException(String erro) {
		super(erro);
	}
	
}
