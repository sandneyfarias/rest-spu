package br.com.sfc.restspu.util;

public class MathVerificationUtil {

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) {
            return false;
        }
        String number = strNumber.replaceAll(",", ".");

        return number.matches("-?\\d+(\\.\\d+)?");
    }


}
