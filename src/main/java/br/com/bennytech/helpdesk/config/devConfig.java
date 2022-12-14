package br.com.bennytech.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.bennytech.helpdesk.services.DBService;

@Configuration
@Profile("dev")
public class devConfig {

	@Autowired
	private DBService dbservice;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	@Bean
	public boolean instanciaDB() {
		if(value.equals("create")) {
			this.dbservice.instanciaDB();
		}
		return false;
	}
	
	
}
