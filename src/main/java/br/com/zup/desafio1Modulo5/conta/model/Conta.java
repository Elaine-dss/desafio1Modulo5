package br.com.zup.desafio1Modulo5.conta.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double valor;
    private Tipo tipo;
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;
    private Status status;

    public Conta() {}

    public Integer getId() { return id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Double getValor() { return valor; }

    public Tipo getTipo() { return tipo; }

    public void setTipo(Tipo tipo) { this.tipo = tipo; }

    public void setValor(Double valor) { this.valor = valor; }

    public LocalDate getDataDeVencimento() { return dataDeVencimento; }

    public void setDataDeVencimento(LocalDate dataDeVencimento) { this.dataDeVencimento = dataDeVencimento; }

    public LocalDateTime getDataDePagamento() { return dataDePagamento; }

    public void setDataDePagamento(LocalDateTime dataDePagamento) { this.dataDePagamento = dataDePagamento; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

}
