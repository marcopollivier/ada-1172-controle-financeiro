package br.com.ada.t1172.ControleFinanceiro.controller;

import br.com.ada.t1172.ControleFinanceiro.model.User;
import br.com.ada.t1172.ControleFinanceiro.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        var findableUser = userRepository.findByEmail(user.getEmail());

        if (findableUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        var resp = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}
