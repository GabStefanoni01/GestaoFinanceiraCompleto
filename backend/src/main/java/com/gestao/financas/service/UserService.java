package com.gestao.financas.service;
import com.gestao.financas.entity.User;import com.gestao.financas.repository.UserRepository;import org.springframework.security.crypto.password.PasswordEncoder;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import java.util.Optional;
@Service public class UserService {
 private final UserRepository repository;private final PasswordEncoder encoder;public UserService(UserRepository r,PasswordEncoder e){repository=r;encoder=e;}
 @Transactional public User register(User user){if(repository.existsByUsername(user.getUsername()))throw new IllegalArgumentException("Nome de usuário já cadastrado.");if(repository.existsByEmail(user.getEmail()))throw new IllegalArgumentException("E-mail já cadastrado.");user.setPassword(encoder.encode(user.getPassword()));user.setEnabled(true);return repository.save(user);}
 public Optional<User> findByUsername(String username){return repository.findByUsername(username);}
 public User getUserById(Long id){return repository.findById(id).orElseThrow(()->new IllegalArgumentException("Usuário não encontrado."));}
}