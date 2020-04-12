package br.com.sfc.restspu.service;

import br.com.sfc.restspu.exception.UnsuportedMathOperationException;
import br.com.sfc.restspu.util.MathVerificationUtil;
import br.com.sfc.restspu.util.converter.NumberConverterUtil;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) {
        if (!MathVerificationUtil.isNumeric(numberOne) || !MathVerificationUtil.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Os valores devem ser numéricos");
        }
        return NumberConverterUtil.convertToDouble(numberOne) + NumberConverterUtil.convertToDouble(numberTwo);
    }

    public Double sub(String numberOne, String numberTwo) {
        if (!MathVerificationUtil.isNumeric(numberOne) || !MathVerificationUtil.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Os valores devem ser numéricos");
        }
        return NumberConverterUtil.convertToDouble(numberOne) - NumberConverterUtil.convertToDouble(numberTwo);
    }

    public Double mul(String numberOne, String numberTwo)  {
        if (!MathVerificationUtil.isNumeric(numberOne) || !MathVerificationUtil.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Os valores devem ser numéricos");
        }
        return NumberConverterUtil.convertToDouble(numberOne) * NumberConverterUtil.convertToDouble(numberTwo);
    }

    public Double div(String numberOne, String numberTwo) {
        if (!MathVerificationUtil.isNumeric(numberOne) || !MathVerificationUtil.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Os valores devem ser numéricos");
        }
        return NumberConverterUtil.convertToDouble(numberOne) / NumberConverterUtil.convertToDouble(numberTwo);
    }

    public Double avg(String numberOne, String numberTwo) {
        if (!MathVerificationUtil.isNumeric(numberOne) || !MathVerificationUtil.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Os valores devem ser numéricos");
        }
        return (NumberConverterUtil.convertToDouble(numberOne) + NumberConverterUtil.convertToDouble(numberTwo))/2;
    }

    public Double sqr(String numberOne) {
        if (!MathVerificationUtil.isNumeric(numberOne)) {
            throw new UnsuportedMathOperationException("Os valores devem ser numéricos");
        }
        return (Double) Math.sqrt(NumberConverterUtil.convertToDouble(numberOne));
    }

}
