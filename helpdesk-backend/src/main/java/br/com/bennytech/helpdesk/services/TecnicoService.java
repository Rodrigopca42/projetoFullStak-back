package br.com.bennytech.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bennytech.helpdesk.domain.Tecnico;
import br.com.bennytech.helpdesk.repositories.TecnicoRepository;
import br.com.bennytech.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id = " +id));
	}


	public List<Tecnico> finAll() {
		return repository.findAll();
	}
	
	
	
	
	
	
	
	
	
}
