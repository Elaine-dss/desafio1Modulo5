package br.com.zup.desafio1Modulo5.conta.service;

import br.com.zup.desafio1Modulo5.conta.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

}
