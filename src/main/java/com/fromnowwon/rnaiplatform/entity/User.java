package com.fromnowwon.rnaiplatform.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User 엔티티
 * - 회원 정보를 저장하는 테이블 매핑
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "password") // toString 출력에서 password 제외
public class User {
  // ==============================
  // 기본 키 설정
  // ==============================
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment 방식으로 자동 값 생성
  private Long id;

  // ==============================
  // 사용자 정보
  // ==============================
  @Column(nullable = false, length = 50)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, length = 100)
  private String email;

  @Column(nullable = false)
  private boolean active = true;

  // ==============================
  // 생성 / 수정 시각
  // ==============================
  @Column(updatable = false)
  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  // ==============================
  // JPA 라이프사이클 콜백
  // ==============================
  @PrePersist // 엔티티가 처음 저장될 때 실행
  public void onCreate() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  @PreUpdate // 엔티티가 수정될 때 실행
  public void onUpdate() {
    this.updatedAt = LocalDateTime.now();
  }

  // ==============================
  // 편의 메서드
  // ==============================
  public void deactivate() {
    this.active = false;
  }

  public void activate() {
    this.active = true;
  }
  
}
