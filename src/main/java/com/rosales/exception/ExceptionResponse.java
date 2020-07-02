package com.rosales.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {

	private LocalDateTime data;	
	private String mensagem;
	private String detalhes;
	
	public ExceptionResponse(LocalDateTime data, String mensagem, String detalhes) {
		this.data = data;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
}
