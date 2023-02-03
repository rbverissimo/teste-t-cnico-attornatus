package br.com.attornatus.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.attornatus.exception.ResourceNotFoundException;
import br.com.attornatus.modelo.Endereco;
import br.com.attornatus.repositories.EnderecoRepository;

@Service
public class EnderecoServices {
	
	private Logger logger = Logger.getLogger(PessoaServices.class.getName());
	
	@Autowired
	EnderecoRepository repositorio; 
	
	public Endereco buscarPorId(Long id) {
		logger.info("Buscando endereco");
		
		return repositorio.findById(id)
				.orElseThrow(() -> 
					new ResourceNotFoundException("Nenhum endereço encontrado nesse ID")); 
	}
	
	public List<Endereco> buscarTodos() {
		
		logger.info("Listando todos os endereços");
		return repositorio.findAll();
	}
	
	public Endereco adicionarEndereco(Endereco e) {
		logger.info("Incluindo Endereco!");
		return repositorio.save(e); 
	}
	
	public Endereco alterarEndereco(Endereco e) {
		logger.info("Alterando Endereço pelo ID");
		
		Endereco enderecoRecebido = repositorio.findById(e.getId())
			.orElseThrow(() ->
				new ResourceNotFoundException("Nenhum endereço encontrado nesse ID"));
		
		enderecoRecebido.setNumero(e.getNumero());
		enderecoRecebido.setLogradouro(e.getLogradouro());
		enderecoRecebido.setCidade(e.getCidade());
		enderecoRecebido.setCep(e.getCep());
		enderecoRecebido.setEnderecoPrincipal(e.isEnderecoPrincipal());
		enderecoRecebido.setPessoa(e.getPessoa());
		
		return repositorio.save(enderecoRecebido); 
	}
	
	
	public void deletar(Long id) {
		logger.info("Deletando registro de Endereço"); 
		
		Endereco e = repositorio.findById(id)
				.orElseThrow(() ->
					new ResourceNotFoundException("Nenhum endereço encontrado nesse ID"));
		repositorio.delete(e);
	}
	
	

}
