package com.fromnowwon.rnaiplatform.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fromnowwon.rnaiplatform.dto.auth.request.LoginRequest;
import com.fromnowwon.rnaiplatform.dto.auth.request.SignUpRequest;
import com.fromnowwon.rnaiplatform.dto.auth.response.LoginResponse;
import com.fromnowwon.rnaiplatform.service.auth.AuthService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  // ==============================
  // 회원가입
  // ==============================
  @PostMapping("/signup")
  public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
    authService.signUp(signUpRequest);
    return ResponseEntity.ok("회원가입이 완료되었습니다.");
  }

  // ==============================
  // 로그인
  // ==============================
  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
    LoginResponse loginResponse = authService.login(loginRequest);
    return ResponseEntity.ok(loginResponse);
  }
}
