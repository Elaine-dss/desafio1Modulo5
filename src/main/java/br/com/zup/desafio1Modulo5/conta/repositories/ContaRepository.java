package br.com.zup.desafio1Modulo5.conta.repositories;

import br.com.zup.desafio1Modulo5.conta.models.Conta;
import br.com.zup.desafio1Modulo5.conta.models.enums.Status;
import br.com.zup.desafio1Modulo5.conta.models.enums.Tipo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends CrudRepository <Conta, Integer> {

    Conta findAllById(Integer id);
    List<Conta> findAllByStatus(Status status);
    List<Conta> findAllByTipo(Tipo tipo);

    @Query(value = "SELECT * FROM contas v WHERE v.valor BETWEEN ?1-10 and ?1+10", nativeQuery = true)
    List<Conta> encontrarContasPorValor(Double valor);

}
