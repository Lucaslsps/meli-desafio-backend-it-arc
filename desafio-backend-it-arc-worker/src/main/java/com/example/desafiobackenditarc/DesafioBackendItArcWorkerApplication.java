package com.example.desafiobackenditarc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.desafiobackenditarc.repository")
@EntityScan(basePackages = "com.example.desafiobackenditarc.model")
@EnableFeignClients(basePackages = "com.example.desafiobackenditarc.clients")
@ComponentScan(basePackages = "com.example.desafiobackenditarc")
@EnableScheduling
public class DesafioBackendItArcWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioBackendItArcWorkerApplication.class, args);
	}

}
