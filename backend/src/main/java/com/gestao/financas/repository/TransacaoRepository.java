package com.gestao.financas.repository;
import com.gestao.financas.model.Transacao;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
public interface TransacaoRepository extends JpaRepository<Transacao,Long>{List<Transacao> findByUser_UsernameOrderByDataDesc(String username);Optional<Transacao> findByIdAndUser_Username(Long id,String username);}