package com.fromnowwon.rnaiplatform.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice // 전역 컨트롤러 예외 처리
public class GlobalExceptionHandler {
  
  // 유효성 검증 실패 처리
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();

    // 필드별 에러 메시지 수집
    ex.getBindingResult().getFieldErrors().forEach(error -> 
      errors.put(error.getField(), error.getDefaultMessage())
    );

    return errors;
  }
}
