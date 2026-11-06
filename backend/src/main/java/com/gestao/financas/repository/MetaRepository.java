package com.gestao.financas.repository;
import com.gestao.financas.model.Meta;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
public interface MetaRepository extends JpaRepository<Meta,Long>{List<Meta> findByUser_Username(String username);Optional<Meta> findByIdAndUser_Username(Long id,String username);}