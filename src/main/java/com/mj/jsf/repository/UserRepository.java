package com.mj.jsf.repository;

import com.mj.jsf.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}
