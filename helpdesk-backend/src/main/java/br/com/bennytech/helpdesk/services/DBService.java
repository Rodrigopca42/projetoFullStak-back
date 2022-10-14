package br.com.bennytech.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bennytech.helpdesk.domain.Chamado;
import br.com.bennytech.helpdesk.domain.Cliente;
import br.com.bennytech.helpdesk.domain.Tecnico;
import br.com.bennytech.helpdesk.domain.enums.Perfil;
import br.com.bennytech.helpdesk.domain.enums.Prioridade;
import br.com.bennytech.helpdesk.domain.enums.Status;
import br.com.bennytech.helpdesk.repositories.ChamadoRepository;
import br.com.bennytech.helpdesk.repositories.ClienteRepository;
import br.com.bennytech.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Valdir Cesar", "672.652.190-15", "valdir@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Alexandre De Moraes", "031.255.190-80", "alex@gmail.com", "123");
		
		Chamado cha1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "chamado 01", "Primerio chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(cha1));
	}
	
}
