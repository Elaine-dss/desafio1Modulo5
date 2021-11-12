package br.com.zup.desafio1Modulo5.conta.services;

import br.com.zup.desafio1Modulo5.conta.models.enums.Status;
import br.com.zup.desafio1Modulo5.conta.models.Conta;
import br.com.zup.desafio1Modulo5.conta.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public void pagarConta(Integer id){
        Conta contaParaPagar = retornarContaPorID(id);
        contaParaPagar.setDataDePagamento(LocalDateTime.now());
        contaParaPagar.setStatus(Status.PAGO);
        contaRepository.save(contaParaPagar);
    }

}
