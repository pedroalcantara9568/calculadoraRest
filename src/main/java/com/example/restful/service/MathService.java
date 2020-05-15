package com.example.restful.service;


import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double soma(Double numeroUm, Double numeroDois) {
        return numeroUm+ numeroDois;
    }

    public Double subtracao(Double numeroUm, Double numeroDois) {
        return numeroUm - numeroDois;
    }

    public Double divisao(Double numeroUm, Double numeroDois) {
        return numeroUm / numeroDois;
    }

    public Double multiplicacao(Double numeroUm, Double numeroDois) {
        return numeroUm * numeroDois;
    }

    public Double media(Double numeroUm, Double numeroDois) {
        return (numeroUm + numeroDois) /2;
    }

    public Double raizQuadrada(Double numero){
        return Math.sqrt(numero);
    }

    public Double converterParaDouble(String strNumber) {
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        if(ehNumerico(number)) return Double.parseDouble(number);
        return 0D;
    }

    public boolean ehNumerico(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
