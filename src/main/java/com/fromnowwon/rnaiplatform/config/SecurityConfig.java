package com.fromnowwon.rnaiplatform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  
  // ==============================
  // 비밀번호 암호화용 PasswordEncoder 빈 등록
  // ==============================
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // ==============================
  // 보안 필터 체인 설정
  // ==============================
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable()) // CSRF 보안 비활성화 (JWT 토큰 기반 인증 사용)
      .headers(headers -> headers.frameOptions(frame -> frame.disable())) // H2 콘솔 frame 허용
      .authorizeHttpRequests(auth -> auth
        .requestMatchers(
            "/api/auth/signup/**", 
            "/api/auth/login/**", 
            "/h2-console/**", 
            "/swagger-ui/**", 
            "/v3/api-docs/**"
        ).permitAll()
        .anyRequest().authenticated()
      )
      .sessionManagement(session -> session
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      ); // 세션 사용 안함 (JWT 토큰 기반 인증 사용)

      return http.build(); // 실제 동작 가능한 SecurityFilterChain 객체로 만듦
  }

}
