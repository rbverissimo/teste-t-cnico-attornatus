package br.com.attornatus.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private String mensagem;
	private String informacoes;
	
	public ExceptionResponse(Date timestamp, 
			String mensagem, String informacoes) {
		this.timestamp = timestamp;
		this.mensagem = mensagem;
		this.informacoes = informacoes;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getInformacoes() {
		return informacoes;
	} 
	

}
