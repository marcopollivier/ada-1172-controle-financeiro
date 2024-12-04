package br.com.ada.t1172.ControleFinanceiro;

import br.com.ada.t1172.ControleFinanceiro.model.User;
import br.com.ada.t1172.ControleFinanceiro.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ControleFinanceiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleFinanceiroApplication.class, args);
	}

}