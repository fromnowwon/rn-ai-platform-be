package com.fromnowwon.rnaiplatform.service.auth;

import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.fromnowwon.rnaiplatform.dto.auth.request.LoginRequest;
import com.fromnowwon.rnaiplatform.dto.auth.request.SignUpRequest;
import com.fromnowwon.rnaiplatform.dto.auth.response.LoginResponse;
import com.fromnowwon.rnaiplatform.entity.User;
import com.fromnowwon.rnaiplatform.enums.Role;
import com.fromnowwon.rnaiplatform.repository.user.UserRepository;
import com.fromnowwon.rnaiplatform.security.JwtTokenProvider;
import com.fromnowwon.rnaiplatform.service.user.UserService;

@Service
public class AuthService {
  
  private final UserRepository userRepository;
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider jwtTokenProvider;

  public AuthService(UserRepository userRepository, UserService userService, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
    this.userRepository = userRepository;
    this.userService = userService;
    this.passwordEncoder = passwordEncoder;
    this.jwtTokenProvider = jwtTokenProvider;
  }

  // ==============================
  // 회원가입
  // ==============================
  public void signUp(SignUpRequest request) {
    if (userService.isEmailDuplicate(request.getEmail())) {
        throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
    }
    
    // 비밀번호 암호화
    String encodedPassword = passwordEncoder.encode(request.getPassword());

    User user = User.builder()
      .username(request.getUsername())
      .password(encodedPassword)
      .email(request.getEmail())
      .role(Role.USER)
      .active(true)
      .build();
    
    userRepository.save(user);
  }

  // ==============================
  // 로그인
  // ==============================
  public LoginResponse login(LoginRequest request) {
    User user = userRepository.findByEmail(request.getEmail())
      .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 이메일입니다."));

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new IllegalArgumentException("잘못된 비밀번호입니다.");
    }

    // JWT 발급
    String token = jwtTokenProvider.generateToken(user.getEmail(), user.getRole().name());

    return LoginResponse.builder()
      .token(token)
      .build();
  }
}
