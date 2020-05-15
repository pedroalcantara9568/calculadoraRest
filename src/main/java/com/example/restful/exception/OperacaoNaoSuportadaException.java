package com.example.restful.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OperacaoNaoSuportadaException extends RuntimeException  {

    private static final long serialVersionUID = 1L;

    public OperacaoNaoSuportadaException (String exception) {
        super(exception);
    }

}