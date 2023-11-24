package com.diplomado.Users.web.rest;

import com.diplomado.Users.dto.ErrorDTO;
import com.diplomado.Users.exception.RequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorDTO> requestExceptionHandler(RequestException ex){
        ErrorDTO error=new ErrorDTO(ex.getMessage());

        return new ResponseEntity<>(error,ex.getStatus());
    }
}
