package com.fromnowwon.rnaiplatform.dto.auth.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// ==============================
// 로그인 성공 시 JWT 토큰 반환 DTO
// ==============================
@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
  
  private String token;
  private String tokenType = "Bearer"; // Bearer 타입으로 기본 설정
}
