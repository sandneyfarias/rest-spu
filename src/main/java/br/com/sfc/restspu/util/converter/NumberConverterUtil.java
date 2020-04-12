package br.com.sfc.restspu.util.converter;

import br.com.sfc.restspu.util.MathVerificationUtil;

public class NumberConverterUtil {

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            return 0D;
        }
        String number = strNumber.replaceAll(",", ".");

        if (MathVerificationUtil.isNumeric(number)) {
            return Double.valueOf(number);
        }
        return 0D;
    }

}
