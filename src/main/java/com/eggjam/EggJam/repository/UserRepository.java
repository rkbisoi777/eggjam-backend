package com.eggjam.EggJam.repository;

import com.eggjam.EggJam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsername(String username);
}
