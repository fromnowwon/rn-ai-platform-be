package com.fromnowwon.rnaiplatform.controller.user;

import org.springframework.web.bind.annotation.*;
import com.fromnowwon.rnaiplatform.entity.User;
import com.fromnowwon.rnaiplatform.service.user.UserService;

import jakarta.validation.Valid;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Tag(name = "User API", description = "회원 관련 CRUD API")
@RestController
@RequestMapping("/api/users")
public class UserController {
  
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  // ==============================
  // 회원 생성 (POST /api/users)
  // ==============================
  @Operation(
      summary = "회원 생성",
      description = "새로운 회원을 등록합니다.",
      responses = {
          @ApiResponse(responseCode = "200", description = "회원 생성 성공"),
          @ApiResponse(responseCode = "400", description = "입력값 유효성 오류")
      }
  )
  @PostMapping
  public User createUser(@Valid @RequestBody User user) {
    return userService.createUser(user); 
  }

  // ==============================
  // 모든 회원 조회 (GET /api/users)
  // ==============================
  @Operation(
      summary = "회원 목록 조회",
      description = "등록된 모든 회원 정보를 조회합니다.",
      responses = {
          @ApiResponse(responseCode = "200", description = "회원 목록 조회 성공")
      }
  )
  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }
}
