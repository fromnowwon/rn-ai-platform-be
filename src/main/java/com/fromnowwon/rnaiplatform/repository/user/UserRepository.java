package com.fromnowwon.rnaiplatform.repository.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fromnowwon.rnaiplatform.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  
  Optional<User> findByEmail(String email);
  boolean existsByEmail(String email);
}
