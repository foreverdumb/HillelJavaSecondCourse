package com.hillel.homework_13;

import com.hillel.homework_13.utils.PseudoGraphicsUtilClass;
import com.hillel.homework_13.utils.ScannerUtils;

public class DrawingNumbersMainClass {
    public static void main(String[] args) {
        String number = String.valueOf(ScannerUtils.setNumber());

        PseudoGraphicsUtilClass.outPutResult(number);
    }
}
