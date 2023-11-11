package com.devcommunity.app.exception;

import com.devcommunity.app.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ItemNotFoundException.class)
    protected ResponseEntity<ErrorDTO> handleResourceNotFoundException(ItemNotFoundException ex){
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<ErrorDTO> handleBadCredentialsException(BadCredentialsException ex){
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ItemAlreadyExistException.class)
    protected ResponseEntity<ErrorDTO> handleItemAlreadyExistException(ItemAlreadyExistException ex){
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<ErrorDTO> handleItemNoSuchElementException(NoSuchElementException ex){
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}