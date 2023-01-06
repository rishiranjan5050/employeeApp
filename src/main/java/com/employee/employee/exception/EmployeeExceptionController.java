package com.employee.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionController {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> exception(EmployeeNotFoundException exp){
        return new ResponseEntity<>("Employee not found ", HttpStatus.NOT_FOUND);
    }
}
