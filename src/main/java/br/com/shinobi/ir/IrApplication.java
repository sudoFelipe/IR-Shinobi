package br.com.shinobi.ir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class IrApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrApplication.class, args);
	}

}
