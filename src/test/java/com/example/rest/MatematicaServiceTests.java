package com.example.rest;


import com.example.rest.service.MatematicaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MatematicaServiceTests {

    @Autowired
    MatematicaService matematicaService;

    @Test
    @DisplayName("soma é calculada com sucesso")
    public void testeSomatorio() {
        Double primeiroNumero = 2.0;
        Double segundoNumero = 2.0;
        Assertions.assertEquals(4.0, matematicaService.soma(primeiroNumero,segundoNumero));
    }

    @Test
    @DisplayName("subtração é calculada com sucesso")
    public void testeSubtracao(){
        Double primeiroNumero = 2.0;
        Double segundoNumero = 2.0;
        Assertions.assertEquals(0, matematicaService.subtracao(primeiroNumero,segundoNumero));
    }

    @Test
    @DisplayName("multiplicação é calculada com sucesso")
    public void multiplicacaoEhCalculadaComSucesso(){
        Double primeiroNumero = 2.0;
        Double segundoNumero = 2.0;
        Assertions.assertEquals(4.0, matematicaService.multiplicacao(primeiroNumero,segundoNumero));
    }

    @Test
    @DisplayName("divisão é calculada com sucesso")
    public void divisaoEhCalculadaComSucesso() {
        Double primeiroNumero = 2.0;
        Double segundoNumero = 2.0;
        Assertions.assertEquals(1, matematicaService.divisao(primeiroNumero,segundoNumero));
    }

    @Test
    @DisplayName("média é calculada com sucesso")
    public void mediaEhCalculadaComSucesso() {
        Double primeiroNumero = 2.0;
        Double segundoNumero = 2.0;
        Assertions.assertEquals(2.0, matematicaService.media(primeiroNumero,segundoNumero));
    }

    @Test
    @DisplayName("raiz quadrada é calculada com sucesso")
    public void raizQuadradaEhCalculadaComSucesso() {
        Double numero = 49.0;
        Assertions.assertEquals(7, matematicaService.raizQuadrada(numero));
    }

    @Test
    @DisplayName("converte String em Double")
    public void converteStringEmDouble() {
        String numeroDois = "2";
        Assertions.assertEquals(2.0, matematicaService.converterParaDouble(numeroDois));
    }

    @Test
    @DisplayName("verdadeiro se recebido uma String numérica")
    public void verficaSeStringRecebidaEhNumerico(){
        String numeroDois = "2";
        Assertions.assertTrue(matematicaService.ehNumerico(numeroDois));
    }

    @Test
    @DisplayName("falso se recebido uma String não numérica")
    public void falsoSeRecebidoUmaStringNaoNumerica(){
        String naoNumerico = "A";
        Assertions.assertFalse(matematicaService.ehNumerico(naoNumerico));
    }


}