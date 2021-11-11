package br.com.zup.desafio1Modulo5.conta.model.dtos;

import br.com.zup.desafio1Modulo5.conta.enums.Status;

public class PagamentoDeContaDTO {

    private Status status;

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

}
