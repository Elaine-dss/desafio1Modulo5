package br.com.zup.desafio1Modulo5.conta.service;

import br.com.zup.desafio1Modulo5.conta.enums.Status;
import br.com.zup.desafio1Modulo5.conta.model.Conta;
import br.com.zup.desafio1Modulo5.conta.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public void CadastrarConta(Conta conta){

        if (conta.getDataDeVencimento().isBefore(LocalDate.now())) {
            conta.setStatus(Status.VENCIDA);
        }
        else {
            conta.setStatus(Status.AGUARDANDO);
        }

        contaRepository.save(conta);
    }

    public List<Conta> retornarContasCadastradas() {
        return (List<Conta>) contaRepository.findAll();
    }

    public Conta retornarContaPorID(Integer id) {
        return contaRepository.findAllById(id);
    }

}
