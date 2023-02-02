package br.com.attornatus.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

@Entity
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	
	@JoinColumn(name="pessoa_id", nullable = false)
	private Pessoa pessoa;
	
	@Column(name="endereco_princial", nullable = false)
	private boolean enderecoPrincipal;
	
	
	public Endereco() {}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public boolean isEnderecoPrincipal() {
		return enderecoPrincipal;
	}

	public void setEnderecoPrincipal(boolean enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, cidade, logradouro, numero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(numero, other.numero);
	}


	
	

}
