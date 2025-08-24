package com.fromnowwon.rnaiplatform.dto.auth.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

// ==============================
// 회원가입 요청 DTO
// ==============================
@Getter
@Setter
public class SignUpRequest {
  
  @NotBlank(message = "아이디는 필수 입력입니다.")
  @Size(min = 3, max = 50, message = "아이디는 3자 이상 50자 이하여야 합니다.")
  private String username;

  @NotBlank(message = "비밀번호는 필수 입력입니다.")
  @Size(min = 6, max = 100, message = "비밀번호는 6자 이상 100자 이하여야 합니다.")
  private String password;

  @NotBlank(message = "이메일은 필수 입력입니다.")
  @Email(message = "이메일 형식이 올바르지 않습니다.")
  private String email;
}
