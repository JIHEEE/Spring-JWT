package com.oopsw.jh.exception;

import com.oopsw.jh.dto.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomAuthenticationException.class)
    protected ResponseEntity<CommonResponse> handleCustomAuthenticationException(CustomAuthenticationException e) {

        log.info("handleCustomAuthenticationException", e);

        CommonResponse response = CommonResponse.builder()
                .code(ErrorCode.AUTHENTICATION_FAILED.getCode())
                .message(e.getMessage())
                .status(ErrorCode.AUTHENTICATION_FAILED.getStatus())
                .build();

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        
    }

    @ExceptionHandler(LoginFailedException.class)
    protected ResponseEntity<CommonResponse> handleLoginFailedException(LoginFailedException e) {

        log.info("handleLoginFailedException", e);

        CommonResponse response = CommonResponse.builder()
                .code(ErrorCode.Login_FAILED.getCode())
                .message(e.getMessage())
                .status(ErrorCode.Login_FAILED.getStatus())
                .build();

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        
    }
    
}
