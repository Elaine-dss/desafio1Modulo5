package br.com.zup.desafio1Modulo5.conta.services;

import br.com.zup.desafio1Modulo5.conta.configs.exceptions.SolicitacaoNaoEncontrada;
import br.com.zup.desafio1Modulo5.conta.models.enums.Status;
import br.com.zup.desafio1Modulo5.conta.models.Conta;
import br.com.zup.desafio1Modulo5.conta.models.enums.Tipo;
import br.com.zup.desafio1Modulo5.conta.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public List<Conta> retornarTodasContasCadastradas() {
        return (List<Conta>) contaRepository.findAll();
    }

    public List<Conta> retornarContasPorFiltro(Status status, Tipo tipo, Double valor) {
        if (status != null) {
            return contaRepository.findAllByStatus(status);
        }
        if (valor != null) {
            return contaRepository.encontrarContasPorValor(valor);
        }
        if (tipo != null) {
            return contaRepository.findAllByTipo(tipo);
        }
        if (retornarTodasContasCadastradas().isEmpty()) {
            throw new SolicitacaoNaoEncontrada("Não encontramos nenhuma conta cadastrada no sistema");
        }
        return retornarTodasContasCadastradas();
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

    public void deletarConta(Integer id) {
        try{
            contaRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException exception) {
            throw new SolicitacaoNaoEncontrada("Conta não encontrada");
        }
    }

}
