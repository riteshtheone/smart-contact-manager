package com.realtime.smartcontactmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realtime.smartcontactmanager.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer>{
    
}
