package com.gestao.financas.service;
import com.gestao.financas.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
@Service public class CustomUserDetailsService implements UserDetailsService {
 private final UserRepository users;public CustomUserDetailsService(UserRepository users){this.users=users;}
 @Override public UserDetails loadUserByUsername(String username){
  var u=users.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Usuário não encontrado."));
  return User.withUsername(u.getUsername()).password(u.getPassword()).authorities("ROLE_USER").disabled(!u.isEnabled()).build();
 }
}