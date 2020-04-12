package br.com.sfc.restspu.resources;

import br.com.sfc.restspu.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class MathController {

    @Autowired
    MathService mathService;

    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathService.sum(numberOne, numberTwo);
    }

    @GetMapping(value = "/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathService.sub(numberOne, numberTwo);
    }

    @GetMapping(value = "/mul/{numberOne}/{numberTwo}")
    public Double mul(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)  {
        return mathService.mul(numberOne, numberTwo);
    }

    @GetMapping(value = "/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathService.div(numberOne, numberTwo);
    }

    @GetMapping(value = "/avg/{numberOne}/{numberTwo}")
    public Double avg(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathService.avg(numberOne, numberTwo);
    }

    @GetMapping(value = "/sqr/{numberOne}")
    public Double sqr(@PathVariable("numberOne") String numberOne) {
        return mathService.sqr(numberOne);
    }

}
