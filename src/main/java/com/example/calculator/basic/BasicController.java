package com.example.calculator.basic;

import static com.example.calculator.model.ResultBuilder.getResult;
import static com.example.calculator.model.ResultBuilder.getResultFromError;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculator.model.ApiResult;


@RestController
@RequestMapping("/calculadora")
public class BasicController {

   @GetMapping("/soma")
   public ApiResult soma(@RequestParam BigDecimal numero, @RequestParam BigDecimal numero2 ) {
      return getResult(numero.add(numero2));
   }

   @GetMapping("/subtracao")
   public ApiResult subtracao(@RequestParam BigDecimal numero , @RequestParam BigDecimal numero2) {
      return getResult(numero.subtract(numero2));
   }

   @GetMapping("/multiplicacao")
   public ApiResult multiplicacao(@RequestParam BigDecimal numero, @RequestParam BigDecimal numero2) {
      return getResult(numero.multiply(numero2));
   }

   @GetMapping("/divisao")
   public ApiResult divisao(@RequestParam BigDecimal numero, @RequestParam BigDecimal divisor) {
      if (divisor.equals(BigDecimal.ZERO)) {
         return getResultFromError("divisor nao pode ser nulo/zero");
      }
      return getResult(numero.divide(divisor, RoundingMode.HALF_EVEN));
   }

}
