package com.sipf.messagemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sipf.messagemanager.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}