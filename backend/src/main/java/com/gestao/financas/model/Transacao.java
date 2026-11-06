package com.gestao.financas.model;
import com.fasterxml.jackson.annotation.JsonIgnore;import com.gestao.financas.entity.User;import jakarta.persistence.*;import jakarta.validation.constraints.*;import java.math.BigDecimal;import java.time.LocalDate;
@Entity @Table(name="transacoes") public class Transacao {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false,length=160) private String descricao;
 @NotNull @DecimalMin("0.01") @Column(nullable=false,precision=19,scale=2) private BigDecimal valor;
 @NotNull @Column(nullable=false) private LocalDate data;
 @NotBlank @Pattern(regexp="RECEITA|DESPESA",flags=Pattern.Flag.CASE_INSENSITIVE) @Column(nullable=false,length=10) private String tipo;
 @JsonIgnore @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="user_id",nullable=false) private User user;
 public Long getId(){return id;}public void setId(Long v){id=v;}public String getDescricao(){return descricao;}public void setDescricao(String v){descricao=v;}public BigDecimal getValor(){return valor;}public void setValor(BigDecimal v){valor=v;}public LocalDate getData(){return data;}public void setData(LocalDate v){data=v;}public String getTipo(){return tipo;}public void setTipo(String v){tipo=v==null?null:v.toUpperCase();}public User getUser(){return user;}public void setUser(User v){user=v;}
}