package com.anymind.btc.walletsummary.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

@Data
public class ExceptionResponse {

    private Date date;
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Date date, HttpStatus status, String message, List<String> errors) {
        this.date = date;
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}
