package com.gestao.financas.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;import jakarta.persistence.*;import jakarta.validation.constraints.*;import java.math.BigDecimal;
@Entity @Table(name="accounts") public class Account {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false,length=100) private String name;
 @NotBlank @Column(nullable=false,length=40) private String type;
 @NotNull @DecimalMin("0.00") @Column(nullable=false,precision=19,scale=2) private BigDecimal balance=BigDecimal.ZERO;
 @JsonIgnore @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="user_id",nullable=false) private User user;
 public Long getId(){return id;}public void setId(Long v){id=v;}public String getName(){return name;}public void setName(String v){name=v;}public String getType(){return type;}public void setType(String v){type=v;}public BigDecimal getBalance(){return balance;}public void setBalance(BigDecimal v){balance=v;}public User getUser(){return user;}public void setUser(User v){user=v;}
}