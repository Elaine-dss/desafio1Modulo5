package br.com.zup.desafio1Modulo5.conta.repositories;

import br.com.zup.desafio1Modulo5.conta.models.Conta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends CrudRepository <Conta, Integer> {

    Conta findAllById(Integer id);

}
