package com.sipf.messagemanager.model;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "message")
public class Message {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name="creation_time")
    @CreatedDate
	private Instant creationTime;
    
    @Column(name="last_update")
    @LastModifiedDate
	private Instant lastUpdate;
    
    @NotNull(message="You must add some content")
    @Pattern(regexp = "^((?!<script>).)*$")
    private String content;
    
    private String icon;
    
    private String link;
    
    private String tags;
    
    @Column(name="due_date")
    private Date dueDate;

}
