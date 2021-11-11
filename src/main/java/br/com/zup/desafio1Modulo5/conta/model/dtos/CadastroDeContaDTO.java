package br.com.zup.desafio1Modulo5.conta.model.dtos;

import br.com.zup.desafio1Modulo5.conta.enums.Tipo;

import java.time.LocalDate;

public class CadastroDeContaDTO {

    private String nome;
    private Double valor;
    private Tipo tipo;
    private LocalDate dataDeVencimento;

    public CadastroDeContaDTO() {}

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Double getValor() { return valor; }

    public void setValor(Double valor) { this.valor = valor; }

    public Tipo getTipo() { return tipo; }

    public void setTipo(Tipo tipo) { this.tipo = tipo; }

    public LocalDate getDataDeVencimento() { return dataDeVencimento; }

    public void setDataDeVencimento(LocalDate dataDeVencimento) { this.dataDeVencimento = dataDeVencimento; }

}
