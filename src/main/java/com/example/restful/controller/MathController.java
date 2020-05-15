package com.example.restful.controller;


import com.example.restful.exception.OperacaoNaoSuportadaException;
import com.example.restful.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    @Autowired
    private MathService mathService;

    @RequestMapping(value = "/soma/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double soma(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
      if(!mathService.ehNumerico(numeroUm) || !mathService.ehNumerico(numeroDois)){
          throw new OperacaoNaoSuportadaException("por favor defina um valor numérico");
      }
        return mathService.soma(mathService.converterParaDouble(numeroUm), mathService.converterParaDouble(numeroDois));
    }
    
    @RequestMapping(value = "/subtrair/{numeroUm}/{numeroDois}" , method = RequestMethod.GET)
    public Double subtracao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
        if(!mathService.ehNumerico(numeroUm) || !mathService.ehNumerico(numeroDois)){
            throw new OperacaoNaoSuportadaException("por favor defina um valor numérico");
        }
        return mathService.subtracao(mathService.converterParaDouble(numeroUm), mathService.converterParaDouble(numeroDois));
    }

    @RequestMapping(value = "/multiplicar/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double multiplicacao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
        if(!mathService.ehNumerico(numeroUm) || !mathService.ehNumerico(numeroDois)) {
            throw new OperacaoNaoSuportadaException("por favor defina um valor numérico");
        }
        return mathService.multiplicacao(mathService.converterParaDouble(numeroUm), mathService.converterParaDouble(numeroDois));
    }

    @RequestMapping(value = "/dividir/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double divisao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
        if(!mathService.ehNumerico(numeroUm) || mathService.ehNumerico(numeroDois)){
            throw new OperacaoNaoSuportadaException("por favor definar um valor numérico");
        }
        return mathService.divisao(mathService.converterParaDouble(numeroUm), mathService.converterParaDouble(numeroDois));
    }

    @RequestMapping(value = "/media/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double media(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
        if(!mathService.ehNumerico(numeroUm) || !mathService.ehNumerico(numeroDois)){
            throw new OperacaoNaoSuportadaException("por favor definar um valor numérico");
        }
        return mathService.media(mathService.converterParaDouble(numeroUm), mathService.converterParaDouble(numeroDois));
    }

    @RequestMapping(value = "/raiz/{numeroUm}", method = RequestMethod.GET)
    public Double raizQuadrada(@PathVariable("numeroUm") String numeroUm) throws OperacaoNaoSuportadaException {
        if(!mathService.ehNumerico(numeroUm)) {
            throw new OperacaoNaoSuportadaException("por favor defina um valor Numerico");
        }
        return mathService.raizQuadrada(mathService.converterParaDouble(numeroUm));
    }


}
