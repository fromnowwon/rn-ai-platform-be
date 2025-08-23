package com.fromnowwon.rnaiplatform.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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
  @NotBlank(message = "Username은 필수 입력입니다.")
  @Size(max = 50, message = "Username은 최대 50자까지 가능합니다.")
  @Column(nullable = false, length = 50)
  private String username;

  @NotBlank(message = "Password는 필수 입력입니다.")
  @Size(min = 6, message = "Password는 최소 6자 이상이어야 합니다.")
  @Column(nullable = false)
  private String password;

  @NotBlank(message = "Email은 필수 입력입니다.")
  @Email(message = "Email 형식이 올바르지 않습니다.")
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
