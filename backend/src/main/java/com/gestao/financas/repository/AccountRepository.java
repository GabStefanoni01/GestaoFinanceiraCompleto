package com.gestao.financas.repository;
import com.gestao.financas.entity.Account;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
public interface AccountRepository extends JpaRepository<Account,Long>{List<Account> findByUser_Username(String username);Optional<Account> findByIdAndUser_Username(Long id,String username);}