package br.com.zup.desafio1Modulo5.conta.models;

import br.com.zup.desafio1Modulo5.conta.models.enums.Status;
import br.com.zup.desafio1Modulo5.conta.models.enums.Tipo;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Double valor;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Column(nullable = false)
    private LocalDate dataDeVencimento;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDePagamento;
    @Enumerated(EnumType.STRING)
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
