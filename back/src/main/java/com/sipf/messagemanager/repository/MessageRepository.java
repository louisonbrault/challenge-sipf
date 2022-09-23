package com.sipf.messagemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sipf.messagemanager.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	
	@Query(value = "SELECT * FROM message WHERE tags LIKE %:tag%", nativeQuery = true)
	List<Message> findByTag(String tag);
	
}