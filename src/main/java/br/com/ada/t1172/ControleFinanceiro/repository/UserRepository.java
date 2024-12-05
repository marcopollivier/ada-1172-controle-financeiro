package br.com.ada.t1172.ControleFinanceiro.repository;

import br.com.ada.t1172.ControleFinanceiro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
