package com.dname.user.custom.exceptions.handler;

import com.dname.user.custom.exceptions.EmptyInputException;
import com.dname.user.custom.exceptions.NoDataException;
import com.dname.user.custom.exceptions.UserNotFoundException;
import com.dname.user.dto.CustomExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<CustomExceptionResponse> handleEmptyException(EmptyInputException emptyInputException) {
        log.error("Empty Input Exception ");
        return new ResponseEntity<>(new CustomExceptionResponse(emptyInputException.getErrorCode(), emptyInputException.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<CustomExceptionResponse> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        log.error("User Not Found Exception ");
        return new ResponseEntity<>(new CustomExceptionResponse(userNotFoundException.getErrorCode(), userNotFoundException.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoDataException.class)
    public ResponseEntity<CustomExceptionResponse> handleNoDataException(NoDataException noDataException) {
        log.error("No Data Exception ");
        return new ResponseEntity<>(new CustomExceptionResponse(noDataException.getErrorCode(), noDataException.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<CustomExceptionResponse> handleNullPointerException(NullPointerException nullPointerException) {
        log.error("Null Pointer Exception ");
        return new ResponseEntity<>(new CustomExceptionResponse(1002, "Null Pointer Exception"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Method Not Found Exception ");
        return new ResponseEntity<>(new CustomExceptionResponse(405, "Method Not Supported"), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
