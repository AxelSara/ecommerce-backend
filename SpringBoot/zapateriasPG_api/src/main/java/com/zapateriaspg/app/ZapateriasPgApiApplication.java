package com.zapateriaspg.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import com.zapateriaspg.app.security.jwt.TokenUtils;

@SpringBootApplication
public class ZapateriasPgApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ZapateriasPgApiApplication.class, args);
		// String secretKeyBase64 = TokenUtils.generaroken();
        // System.out.println("Clave secreta en base64: " + secretKeyBase64);
	}

}
