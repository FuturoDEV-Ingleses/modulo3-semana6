package com.example.testeaula2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "produto")
@NoArgsConstructor // por padrão as entities precisam de um construtor vazio, por causa do Spring
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;
    private Double valorProduto;
    private Double descontoVip;
    private LocalDate dataCriacaoProduto;

    public Produto(String nomeProduto, Double valorProduto, Double descontoVip, LocalDate dataCriacaoProduto) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.descontoVip = descontoVip;
        this.dataCriacaoProduto = dataCriacaoProduto;
    }
}
