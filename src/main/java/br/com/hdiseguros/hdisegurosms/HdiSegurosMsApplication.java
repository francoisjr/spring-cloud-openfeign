package br.com.hdiseguros.hdisegurosms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HdiSegurosMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HdiSegurosMsApplication.class, args);
	}

}
