package com.fromnowwon.rnaiplatform.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
  
  // ==============================
  // JWT 관련 기본 설정값
  // ==============================
  private final String SECRET_KEY = "MySuperSecretKeyForJwtTokenThatShouldBeLongEnough";
  private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1시간

  private final Key key;

  public JwtTokenProvider() {
    this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
  }

  // ==============================
  // 토큰 생성
  // ==============================
  public String generateToken(String username, String role) {
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

    return Jwts.builder()
      .setSubject(username) // 토큰 주체
      .claim("role", role) // 추가 정보
      .setIssuedAt(now) // 발급 시간
      .setExpiration(expiryDate) // 만료 시간
      .signWith(key, SignatureAlgorithm.HS256) // 서명
      .compact();
  }
}



