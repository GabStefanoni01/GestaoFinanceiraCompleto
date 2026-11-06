package com.gestao.financas.model;
import com.fasterxml.jackson.annotation.JsonIgnore;import com.gestao.financas.entity.User;import jakarta.persistence.*;import jakarta.validation.constraints.*;import java.math.BigDecimal;
@Entity @Table(name="meta") public class Meta {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false,length=160) private String descricao;
 @NotNull @DecimalMin("0.01") @Column(nullable=false,precision=19,scale=2) private BigDecimal valorObjetivo;
 @NotNull @DecimalMin("0.00") @Column(nullable=false,precision=19,scale=2) private BigDecimal valorAtual=BigDecimal.ZERO;
 @JsonIgnore @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="user_id") private User user;
 public Long getId(){return id;}public void setId(Long v){id=v;}public String getDescricao(){return descricao;}public void setDescricao(String v){descricao=v;}public BigDecimal getValorObjetivo(){return valorObjetivo;}public void setValorObjetivo(BigDecimal v){valorObjetivo=v;}public BigDecimal getValorAtual(){return valorAtual;}public void setValorAtual(BigDecimal v){valorAtual=v;}public User getUser(){return user;}public void setUser(User v){user=v;}
}