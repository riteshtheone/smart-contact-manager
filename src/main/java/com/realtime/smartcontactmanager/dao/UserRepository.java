package com.realtime.smartcontactmanager.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realtime.smartcontactmanager.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
