package br.com.bennytech.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bennytech.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
