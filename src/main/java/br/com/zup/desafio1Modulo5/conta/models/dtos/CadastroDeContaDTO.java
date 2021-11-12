package br.com.zup.desafio1Modulo5.conta.models.dtos;

import br.com.zup.desafio1Modulo5.conta.models.enums.Tipo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CadastroDeContaDTO {

    @NotBlank(message = "Nome obrigatório")
    private String nome;
    @NotNull(message = "Valor obrigatório")
    @Min(value = 1, message = "Valor deve ser de no mínimo 1.00")
    private Double valor;
    private Tipo tipo;
    @NotNull(message = "Data de vencimento obrigatória")
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
