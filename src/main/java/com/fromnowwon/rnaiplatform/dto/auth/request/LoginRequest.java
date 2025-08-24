package com.fromnowwon.rnaiplatform.dto.auth.request;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// ==============================
// 로그인 요청 DTO
// ==============================
@Getter
@Setter
public class LoginRequest {
  
  @NotBlank(message = "이메일은 필수 입력입니다.")
  @Email(message = "이메일 형식이 올바르지 않습니다.")
  private String email;

  @NotBlank(message = "비밀번호는 필수 입력입니다.")
  private String password;
}
