package com.fromnowwon.rnaiplatform.dto.auth.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// ==============================
// 로그인 응답 DTO (JWT 반환용)
// ==============================
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
  
  private String token;
  @Builder.Default
  private String tokenType = "Bearer"; // Bearer 타입으로 기본 설정
}
