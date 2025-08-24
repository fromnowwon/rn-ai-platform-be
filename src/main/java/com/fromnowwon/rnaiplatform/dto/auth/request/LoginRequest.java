package com.fromnowwon.rnaiplatform.dto.auth.request;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

// ==============================
// 로그인 요청 DTO
// ==============================
@Getter
@Setter
public class LoginRequest {
  
  @NotBlank(message = "아이디는 필수 입력입니다.")
  private String username;

  @NotBlank(message = "비밀번호는 필수 입력입니다.")
  private String password;
}
