package br.com.attornatus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.modelo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {}
