package br.com.ada.t1172.ControleFinanceiro.repository;

import br.com.ada.t1172.ControleFinanceiro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
