package br.com.bennytech.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bennytech.helpdesk.domain.Chamado;
import br.com.bennytech.helpdesk.domain.Cliente;
import br.com.bennytech.helpdesk.domain.Tecnico;
import br.com.bennytech.helpdesk.domain.dtos.ChamadoDTO;
import br.com.bennytech.helpdesk.domain.enums.Prioridade;
import br.com.bennytech.helpdesk.domain.enums.Status;
import br.com.bennytech.helpdesk.repositories.ChamadoRepository;
import br.com.bennytech.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
		}

	public Chamado create(@Valid ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}

	private Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
		Cliente cliene = clienteService.findById(obj.getCliente());
		
		Chamado chamado = new Chamado();
		if(obj.getId() != null) {
			chamado.setId(obj.getId());
		}
		
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliene);
		chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		chamado.setStatus(Status.toEnum(obj.getStatus()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservacoes(obj.getObservacoes());
		return chamado;
	}
	
	
	
	
	
	
	
	
	
	
}
