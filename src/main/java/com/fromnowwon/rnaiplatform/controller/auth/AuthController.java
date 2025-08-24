package com.fromnowwon.rnaiplatform.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.fromnowwon.rnaiplatform.dto.auth.request.LoginRequest;
import com.fromnowwon.rnaiplatform.dto.auth.request.SignUpRequest;
import com.fromnowwon.rnaiplatform.dto.auth.response.LoginResponse;
import com.fromnowwon.rnaiplatform.service.auth.AuthService;
import jakarta.validation.Valid;

@Tag(name = "Auth", description = "회원가입/로그인 API")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  // ==============================
  // 회원가입
  // ==============================
  @Operation(summary = "회원가입", description = "새로운 사용자를 등록합니다")
  @PostMapping("/signup")
  public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
    authService.signUp(signUpRequest);
    return ResponseEntity.ok("회원가입이 완료되었습니다.");
  }

  // ==============================
  // 로그인
  // ==============================
  @Operation(summary = "로그인", description = "이메일/비밀번호로 로그인 후 JWT 반환")
  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
    LoginResponse loginResponse = authService.login(loginRequest);
    return ResponseEntity.ok(loginResponse);
  }
}
