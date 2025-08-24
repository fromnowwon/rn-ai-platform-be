package com.fromnowwon.rnaiplatform.service.auth;

import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.fromnowwon.rnaiplatform.dto.auth.request.SignUpRequest;
import com.fromnowwon.rnaiplatform.entity.User;
import com.fromnowwon.rnaiplatform.enums.Role;
import com.fromnowwon.rnaiplatform.repository.user.UserRepository;
import com.fromnowwon.rnaiplatform.security.JwtTokenProvider;

@Service
public class AuthService {
  
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider jwtTokenProvider;

  public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtTokenProvider = jwtTokenProvider;
  }

  // ==============================
  // 회원가입
  // ==============================
  public void signUp(SignUpRequest request) {
    
    // 비밀번호 암호화
    String encodedPassword = passwordEncoder.encode(request.getPassword());

    User user = User.builder()
      .username(request.getUsername())
      .password(encodedPassword)
      .email(request.getEmail())
      .role(Role.USER)
      .build();
    
    userRepository.save(user);
  }

}
