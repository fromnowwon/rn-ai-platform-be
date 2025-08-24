package com.fromnowwon.rnaiplatform.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice // 전역 컨트롤러 예외 처리
public class GlobalExceptionHandler {
  
  // ==============================
  // 유효성 검증 실패 처리
  // ==============================
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
      Map<String, String> errors = new HashMap<>();

      // 필드별 에러 메시지 수집
      ex.getBindingResult().getFieldErrors().forEach(error ->
          errors.put(error.getField(), error.getDefaultMessage())
      );

      return ResponseEntity.badRequest().body(errors); // 400 반환
  }

  // ==============================
  // 일반 IllegalArgumentException 처리
  // ==============================
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException ex) {
      Map<String, String> error = new HashMap<>();
      error.put("error", ex.getMessage());

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }


}
