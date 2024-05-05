package com.guilhermedevsecops.start.api.exception;

import java.io.Serializable;
import org.springframework.http.HttpHeaders;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {
    @SuppressWarnings("rawtypes")
    @ExceptionHandler({
        EmptyResultDataAccessException.class
    })
    public ResponseEntity errorNotFound(Exception ex){
        return ResponseEntity.notFound().build();
    }
    @SuppressWarnings("rawtypes")
    @ExceptionHandler({
        IllegalArgumentException.class
    })
    public ResponseEntity errorBadRequest(Exception ex){
        return ResponseEntity.badRequest().build();
    }

   protected ResponseEntity<Object> handleHttpRequestMethodNotSupported( HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers,
                                                                         HttpStatusCode status,
                                                                         WebRequest request) {

		return new ResponseEntity<>(new ExceptionError("Operação não permitida"), HttpStatus.METHOD_NOT_ALLOWED);
	}
}

class ExceptionError implements Serializable{
    private String error;
    ExceptionError(String error){
        this.error = error;
    }
    public String getError(){
        return error;
    }
}

