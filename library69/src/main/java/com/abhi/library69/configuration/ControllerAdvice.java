package com.abhi.library69.configuration;

import ch.qos.logback.core.joran.sanity.Pair;
import jakarta.validation.constraints.Null;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(NullPointerException e){
        return new ResponseEntity<>("Something went wrong, Please try again",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){

        Map<String,String> errorMap = new HashMap<>();
        for(FieldError fieldError : e.getBindingResult().getFieldErrors()){
            errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        }


        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }

}
