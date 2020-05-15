package com.example.restful;


import com.example.restful.exception.OperacaoNaoSuportadaException;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    @RequestMapping(value = "/soma/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double soma(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
      if(!isNumeric(numeroUm) || !isNumeric(numeroDois)) throw new OperacaoNaoSuportadaException("por favor defina um valor numérico");
        return convertToDouble(numeroUm) + convertToDouble(numeroDois);
    }
    
    @RequestMapping(value = "/subtrair/{numeroUm}/{numeroDois}" , method = RequestMethod.GET)
    public Double subtracao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
        if(!isNumeric(numeroUm) || !isNumeric(numeroDois)) throw new OperacaoNaoSuportadaException("por favor defina um valor numérico");
        return convertToDouble(numeroUm) - convertToDouble(numeroDois);
    }

    @RequestMapping(value = "/multiplicar/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double multiplicacao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
        if(!isNumeric(numeroUm) || !isNumeric(numeroDois)) throw new OperacaoNaoSuportadaException("por favor defina um valor numérico");
        return convertToDouble(numeroUm) * convertToDouble(numeroDois);
    }

    @RequestMapping(value = "/dividir/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double divisao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
        if(!isNumeric(numeroUm) || isNumeric(numeroDois)) throw new OperacaoNaoSuportadaException("por favor definar um valor numérico");
        return (convertToDouble(numeroUm) / convertToDouble(numeroDois)) ;
    }

    @RequestMapping(value = "/media/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double media(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws OperacaoNaoSuportadaException {
        if(!isNumeric(numeroUm) || isNumeric(numeroDois)) throw new OperacaoNaoSuportadaException("por favor definar um valor numérico");
        return (convertToDouble(numeroUm) + convertToDouble(numeroDois)) / 2;
    }

    @RequestMapping(value = "/raiz/{numeroUm}", method = RequestMethod.GET)
    public Double raizQuadrada(@PathVariable("numeroUm") String numeroUm) throws OperacaoNaoSuportadaException {
        if(!isNumeric(numeroUm)) throw new OperacaoNaoSuportadaException("por favor defina um valor Numerico");
        return Math.sqrt(convertToDouble(numeroUm));
    }


    private Double convertToDouble(String strNumber) {
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
