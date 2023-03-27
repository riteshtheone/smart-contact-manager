package com.realtime.smartcontactmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realtime.smartcontactmanager.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public UserEntity findUserByEmail(String email);
}
