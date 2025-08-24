package com.fromnowwon.rnaiplatform.controller.user;

import org.springframework.web.bind.annotation.*;
import com.fromnowwon.rnaiplatform.entity.User;
import com.fromnowwon.rnaiplatform.service.user.UserService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
  
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  // 회원 생성
  @PostMapping
  public User createUser(@Valid @RequestBody User user) {
    return userService.createUser(user); 
  }

  // 모든 회원 조회
  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }
}
