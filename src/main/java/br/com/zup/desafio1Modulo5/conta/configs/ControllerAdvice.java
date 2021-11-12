package br.com.zup.desafio1Modulo5.conta.configs;

import br.com.zup.desafio1Modulo5.conta.configs.exceptions.DadosDigitadosIncorretamente;
import br.com.zup.desafio1Modulo5.conta.configs.exceptions.SolicitacaoNaoEncontrada;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MsgParaErros> manipularErrosDeValidacao(MethodArgumentNotValidException exception) {
        List<MsgParaErros> msgsDeErro = new ArrayList<>();
        for (FieldError referencia : exception.getFieldErrors()) {
            MsgParaErros msgParaErros = new MsgParaErros(referencia.getDefaultMessage());
            msgsDeErro.add(msgParaErros);
        }
        return msgsDeErro;
    }

    @ExceptionHandler(SolicitacaoNaoEncontrada.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MsgParaErros manipularSolicitacaoNaoEncontrada(SolicitacaoNaoEncontrada exception) {
        return new MsgParaErros(exception.getMessage());
    }

    @ExceptionHandler(DadosDigitadosIncorretamente.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MsgParaErros manipularDadosDigitadosIncorretamente(DadosDigitadosIncorretamente exception) {
        return new MsgParaErros(exception.getMessage());
    }

    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MsgParaErros manipularErrosDeFormatoInvalido(InvalidFormatException exception) {
        return new MsgParaErros("Formato inválido");
    }

}
