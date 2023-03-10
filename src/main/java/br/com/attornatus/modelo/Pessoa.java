package br.com.attornatus.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pessoas")
public class Pessoa implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="pessoa_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column(name="data-de-nascimento")
	private String dataDeNascimento;
	
	@OneToMany(mappedBy = "enderecos")
	private List<Endereco> enderecos;
	
	public Pessoa() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) throws Exception {
		
		if(dataDeNascimento.length() >= 9) {
			throw new Exception("Data inválida");
		}
		String padrao = "dd/mm/yyyy";
		SimpleDateFormat dataFormatada = new SimpleDateFormat(padrao);
		this.dataDeNascimento = dataFormatada.format(dataDeNascimento);
	}

	

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDeNascimento, enderecos, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(dataDeNascimento, other.dataDeNascimento) && Objects.equals(enderecos, other.enderecos)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	
	

}
