package com.anymind.btc.walletsummary.exception;

import java.util.ArrayList;
import java.util.List;

public class InvalidDataException extends RuntimeException{

    public InvalidDataException(ExceptionResponse exceptionResponse) {
        super(String.valueOf(exceptionResponse));
    }

    public static void invalidData(String validationMessage) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse();
        List<String> errors = new ArrayList<String>();
        errors.add(validationMessage);
        exceptionResponse.setErrors(errors);
        throw new InvalidDataException(exceptionResponse);
    }
}
