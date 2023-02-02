package br.com.attornatus.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.attornatus.exception.ResourceNotFoundException;
import br.com.attornatus.modelo.Pessoa;
import br.com.attornatus.repositories.PessoaRepository;

@Service
public class PessoaServices {
	
	private Logger logger = Logger.getLogger(PessoaServices.class.getName());
	
	@Autowired
	PessoaRepository repositorio;
	
	public Pessoa buscarPorId(Long id) {
		logger.info("Buscando Pessoa!");
		
		return repositorio.findById(id)
				.orElseThrow(() -> 
					new ResourceNotFoundException("No records found for this ID")); 
	}
	
	
	public List<Pessoa> buscarTodos() {
		
		logger.info("Buscando todas as Pessoas");
		return repositorio.findAll();
	}
	
	
	public Pessoa adicionarPessoa(Pessoa p) {
		logger.info("Creating one person!");
		return repositorio.save(p); 
	}
	
	public Pessoa alterarPessoa(Pessoa p) {
		logger.info("UPDATE na pessoa");
		
		Pessoa pessoaRecebida = repositorio.findById(p.getId())
			.orElseThrow(() ->
				new ResourceNotFoundException("No records found for this ID"));
		
		pessoaRecebida.setNome(p.getNome());
		pessoaRecebida.setDataDeNascimento(p.getDataDeNascimento());
		pessoaRecebida.setEnderecos(p.getEnderecos());
		
		return repositorio.save(pessoaRecebida); 
	}
	
	public void deletar(Long id) {
		logger.info("Deletando registro de Pessoa"); 
		
		Pessoa pessoa = repositorio.findById(id)
				.orElseThrow(() ->
					new ResourceNotFoundException("No records found for this ID"));
		repositorio.delete(pessoa);
	}
	
	

}
