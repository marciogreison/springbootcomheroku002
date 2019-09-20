package com.kazale.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kazale.api.security.entities.Usuario;
import com.kazale.api.security.enums.PerfilEnum;
import com.kazale.api.security.repositories.UsuarioRepository;
import com.kazale.api.utils.SenhaUtils;

@SpringBootApplication
public class P27Application {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(P27Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			Usuario usuario = new Usuario();
			usuario.setEmail("marcio.azevedo1@criainovacao.com.br");
			usuario.setPerfil(PerfilEnum.ROLE_USUARIO);
			usuario.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(usuario);
			
			Usuario admin = new Usuario();
			admin.setEmail("marcio.azevedo2@criainovacao.com.br");
			admin.setPerfil(PerfilEnum.ROLE_ADMIN);
			admin.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(admin);
			
		};
	}
}
