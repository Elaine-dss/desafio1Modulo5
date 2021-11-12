package br.com.zup.desafio1Modulo5.conta.controllers;

import br.com.zup.desafio1Modulo5.conta.configs.exceptions.DadosDigitadosIncorretamente;
import br.com.zup.desafio1Modulo5.conta.configs.exceptions.SolicitacaoNaoEncontrada;
import br.com.zup.desafio1Modulo5.conta.models.Conta;
import br.com.zup.desafio1Modulo5.conta.models.dtos.CadastroDeContaDTO;
import br.com.zup.desafio1Modulo5.conta.models.dtos.ExibicaoDeContasDTO;
import br.com.zup.desafio1Modulo5.conta.models.dtos.PagamentoDeContaDTO;
import br.com.zup.desafio1Modulo5.conta.models.enums.Status;
import br.com.zup.desafio1Modulo5.conta.services.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta cadastrarConta(@RequestBody @Valid CadastroDeContaDTO cadastroDeContaDTO) {
        Conta conta = modelMapper.map(cadastroDeContaDTO, Conta.class);
        contaService.CadastrarConta(conta);
        return contaService.retornarContaPorID(conta.getId());
    }

    @GetMapping
    public List<ExibicaoDeContasDTO> exibirContasCadastradas() {
        List<ExibicaoDeContasDTO> contasDTOS = new ArrayList<>();
        for (Conta referencia : contaService.retornarContasCadastradas()) {
            contasDTOS.add(modelMapper.map(referencia, ExibicaoDeContasDTO.class));
        }
        if (contasDTOS.isEmpty()) {
            throw new SolicitacaoNaoEncontrada("Não encontramos nenhuma conta cadastrada no sistema");
        }
        return contasDTOS;
    }

    @GetMapping("/{id}")
    public Conta exibirContaPorId(@PathVariable Integer id) {
        for (Conta referencia : contaService.retornarContasCadastradas()) {
            if (Objects.equals(referencia.getId(), id)) {
                return contaService.retornarContaPorID(id);
            }
        }
        throw new SolicitacaoNaoEncontrada("Conta não encontrada");
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Conta pagarConta(@PathVariable Integer id, @RequestBody PagamentoDeContaDTO pagamentoDeContaDTO) {
        Conta contaId = contaService.retornarContaPorID(id);
        for (Conta referencia : contaService.retornarContasCadastradas()) {
            if (Objects.equals(referencia.getId(), id)) {
                if (pagamentoDeContaDTO.getStatus() == Status.PAGO) {
                    if (contaId.getStatus() == Status.PAGO) {
                        throw new DadosDigitadosIncorretamente("Esta conta já foi paga");
                    }
                    contaService.pagarConta(id);
                    return contaId;
                }
                throw new DadosDigitadosIncorretamente("Status de pagamento inválido");
            }
        }
        throw new SolicitacaoNaoEncontrada("Conta não encontrada");
    }

}
