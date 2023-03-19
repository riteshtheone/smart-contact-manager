package com.realtime.smartcontactmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realtime.smartcontactmanager.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
