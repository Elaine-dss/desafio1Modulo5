package br.com.zup.desafio1Modulo5.conta.controller;

import br.com.zup.desafio1Modulo5.conta.model.Conta;
import br.com.zup.desafio1Modulo5.conta.model.dtos.CadastroDeContaDTO;
import br.com.zup.desafio1Modulo5.conta.service.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta cadastrarConta(@RequestBody CadastroDeContaDTO cadastroDeContaDTO) {
        Conta conta = modelMapper.map(cadastroDeContaDTO, Conta.class);
        contaService.CadastrarConta(conta);
        return contaService.retornarContaPorID(conta.getId());
    }

}
