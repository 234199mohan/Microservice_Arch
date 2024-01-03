package com.mohan.user.service.userexception;

import com.mohan.user.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    ResponseEntity<ApiResponse>handleResourceNotFound(UserException ex){
     ex.getMessage();
     ApiResponse respo = ApiResponse.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
     return new ResponseEntity<ApiResponse>(respo, HttpStatus.NOT_FOUND);
    }
}
