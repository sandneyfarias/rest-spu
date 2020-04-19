package br.com.sfc.restspu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RestSpuApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestSpuApplication.class, args);
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);

		String result = bCryptPasswordEncoder.encode("admin123");

		System.out.println("O resultado " +result);

	}

}
