package br.com.zup.desafio1Modulo5;

import br.com.zup.desafio1Modulo5.conta.controllers.ContaController;
import br.com.zup.desafio1Modulo5.conta.models.Conta;
import br.com.zup.desafio1Modulo5.conta.models.dtos.CadastroDeContaDTO;
import br.com.zup.desafio1Modulo5.conta.models.enums.Tipo;
import br.com.zup.desafio1Modulo5.conta.services.ContaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

@SpringBootTest
public class ContaControllerTest {
    @InjectMocks
    ContaController contaController;

    @MockBean
    private ContaService contaService;

    private CadastroDeContaDTO cadastroDeContaDTO;
    private Conta conta;

    @BeforeEach
    public void setup(){
        this.cadastroDeContaDTO = new CadastroDeContaDTO();
        this.cadastroDeContaDTO.setNome("nome");
        this.cadastroDeContaDTO.setValor(123.00);
        this.cadastroDeContaDTO.setTipo(Tipo.LUZ);
        this.cadastroDeContaDTO.setDataDeVencimento(LocalDate.now());

        this.conta = new Conta();
        this.conta.setNome("nome");
        this.conta.setValor(123.00);
        this.conta.setTipo(Tipo.LUZ);
        this.conta.setDataDeVencimento(LocalDate.now());
    }

    //@Test
  //  public void setCadastroDeConta() {
//        Mockito.when(this.contaService.CadastrarConta(Mockito.any())).thenReturn(conta);
//        Mockito.doNothing().when(this.contaService).CadastrarConta(conta);
//        var result = contaController.cadastrarConta(cadastroDeContaDTO);
//        Assertions.assertEquals(result, conta);
//    }
    }