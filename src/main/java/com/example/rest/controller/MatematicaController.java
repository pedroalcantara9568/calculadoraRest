package com.example.rest.controller;


import com.example.rest.exception.OperacaoNaoSuportadaException;
import com.example.rest.service.MatematicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MatematicaController {

    @Autowired
    private MatematicaService matematicaService;

    @RequestMapping(value = "/soma/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double soma(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
      if(!matematicaService.ehNumerico(numeroUm) || !matematicaService.ehNumerico(numeroDois)){
          throw new OperacaoNaoSuportadaException("por favor defina um valor numérico");
      }
        return matematicaService.soma(matematicaService.converterParaDouble(numeroUm), matematicaService.converterParaDouble(numeroDois));
    }
    
    @RequestMapping(value = "/subtrair/{numeroUm}/{numeroDois}" , method = RequestMethod.GET)
    public Double subtracao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
        if(!matematicaService.ehNumerico(numeroUm) || !matematicaService.ehNumerico(numeroDois)){
            throw new OperacaoNaoSuportadaException("por favor defina um valor numérico");
        }
        return matematicaService.subtracao(matematicaService.converterParaDouble(numeroUm), matematicaService.converterParaDouble(numeroDois));
    }

    @RequestMapping(value = "/multiplicar/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double multiplicacao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
        if(!matematicaService.ehNumerico(numeroUm) || !matematicaService.ehNumerico(numeroDois)) {
            throw new OperacaoNaoSuportadaException("por favor defina um valor numérico");
        }
        return matematicaService.multiplicacao(matematicaService.converterParaDouble(numeroUm), matematicaService.converterParaDouble(numeroDois));
    }

    @RequestMapping(value = "/dividir/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double divisao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
        if(!matematicaService.ehNumerico(numeroUm) || !matematicaService.ehNumerico(numeroDois)){
            throw new OperacaoNaoSuportadaException("por favor definar um valor numérico");
        }
        return matematicaService.divisao(matematicaService.converterParaDouble(numeroUm), matematicaService.converterParaDouble(numeroDois));
    }

    @RequestMapping(value = "/media/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double media(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
        if(!matematicaService.ehNumerico(numeroUm) || !matematicaService.ehNumerico(numeroDois)){
            throw new OperacaoNaoSuportadaException("por favor definar um valor numérico");
        }
        return matematicaService.media(matematicaService.converterParaDouble(numeroUm), matematicaService.converterParaDouble(numeroDois));
    }

    @RequestMapping(value = "/raiz/{numeroUm}", method = RequestMethod.GET)
    public Double raizQuadrada(@PathVariable("numeroUm") String numeroUm) throws OperacaoNaoSuportadaException {
        if(!matematicaService.ehNumerico(numeroUm)) {
            throw new OperacaoNaoSuportadaException("por favor defina um valor Numerico");
        }
        return matematicaService.raizQuadrada(matematicaService.converterParaDouble(numeroUm));
    }


}
