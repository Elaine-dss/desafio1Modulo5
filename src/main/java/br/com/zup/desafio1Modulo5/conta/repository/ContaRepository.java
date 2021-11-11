package br.com.zup.desafio1Modulo5.conta.repository;

import br.com.zup.desafio1Modulo5.conta.model.Conta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends CrudRepository <Conta, Integer> {

    Conta findAllById(Integer id);

}
