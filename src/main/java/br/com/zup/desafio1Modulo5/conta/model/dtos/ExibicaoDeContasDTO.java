package br.com.zup.desafio1Modulo5.conta.model.dtos;

import br.com.zup.desafio1Modulo5.conta.enums.Status;

public class ExibicaoDeContasDTO {

    private Integer id;
    private String nome;
    private Double valor;
    private Status status;

    public ExibicaoDeContasDTO() {}

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Double getValor() { return valor; }

    public void setValor(Double valor) { this.valor = valor; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

}
