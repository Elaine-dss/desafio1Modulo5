package br.com.zup.desafio1Modulo5.conta.models.dtos;

import br.com.zup.desafio1Modulo5.conta.models.enums.Status;

public class PagamentoDeContaDTO {

    private Status status;

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

}
