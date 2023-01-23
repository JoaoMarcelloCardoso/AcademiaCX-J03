package com.demo.academiacx.repository;

import com.demo.academiacx.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {


}
