package com.hillel.homework_13;

import com.hillel.homework_13.utils.PseudoGraphicsUtilClass;
import com.hillel.homework_13.utils.ScannerUtilClass;

public class DrawingNumbersMainClass {
    public static void main(String[] args) {
        String number = String.valueOf(ScannerUtilClass.setNumber());

        PseudoGraphicsUtilClass.outPutResult(number);
    }
}
