package br.com.zup.desafio1Modulo5.conta.controller;

import br.com.zup.desafio1Modulo5.conta.model.Conta;
import br.com.zup.desafio1Modulo5.conta.model.dtos.CadastroDeContaDTO;
import br.com.zup.desafio1Modulo5.conta.model.dtos.ExibicaoDeContasDTO;
import br.com.zup.desafio1Modulo5.conta.service.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    public List<ExibicaoDeContasDTO> exibirContasCadastradas() {
        List<ExibicaoDeContasDTO> contasDTOS = new ArrayList<>();
        for (Conta conta : contaService.retornarContasCadastradas()) {
            contasDTOS.add(modelMapper.map(conta, ExibicaoDeContasDTO.class));
        }
        return contasDTOS;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Conta pagarConta(@PathVariable Integer id) {
        contaService.pagarConta(id);
        return contaService.retornarContaPorID(id);
    }

}
