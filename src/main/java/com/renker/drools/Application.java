package com.renker.drools;

import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.model.KieModuleModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
	public KieServices kieService (){
		return KieServices.Factory.get();	
	}
	
	@Bean
	public KieRepository kieRepository(){
		return kieService().getRepository();
	}
	
	@Bean
	public KieModuleModel kieModuleModel(){
		return kieService().newKieModuleModel();
	}
	
	@Bean
	public KieFileSystem kieFileSystem(){
		return kieService().newKieFileSystem();
	}
}
