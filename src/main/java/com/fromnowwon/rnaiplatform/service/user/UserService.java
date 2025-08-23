package com.fromnowwon.rnaiplatform.service.user;

import org.springframework.stereotype.Service;
import com.fromnowwon.rnaiplatform.entity.User;
import com.fromnowwon.rnaiplatform.repository.user.UserRepository;

import java.util.List;

@Service
public class UserService {
  
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  // 회원 생성
  public User createUser(User user) {
    return userRepository.save(user);
  }

  // 모든 회원 조회
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  // username으로 조회
  public User getUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }
}
