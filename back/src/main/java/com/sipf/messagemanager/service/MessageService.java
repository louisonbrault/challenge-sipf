package com.sipf.messagemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipf.messagemanager.model.Message;
import com.sipf.messagemanager.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
    MessageRepository messageRepository;   

	// CREATE 
	public Message createMessage(Message message) {
	    return messageRepository.save(message);
	}
	
	// READ
	public List<Message> getMessages(Optional<String> tag) {
		if (tag.isPresent()) {
			return messageRepository.findByTag(tag.get());
		} else {
			return messageRepository.findAll();
		}
	}
	
	// READ ONE
	public Optional<Message> getMessage(final Long id) {
		return messageRepository.findById(id);
	}
	
	// UPDATE
    public Message updateMessage(Long messageId, Message messageDetails) {
    Message message = messageRepository.findById(messageId).get();
    if (messageDetails.getContent() != null) {
    	message.setContent(messageDetails.getContent());
    }
    if (messageDetails.getIcon() != null) {
    	message.setIcon(messageDetails.getIcon());
    }
	if (messageDetails.getLink() != null) {
    	message.setLink(messageDetails.getLink());
	}
	if (messageDetails.getTags() != null) {
    	message.setTags(messageDetails.getTags());
	}
	if (messageDetails.getDueDate() != null) {
    	message.setDueDate(messageDetails.getDueDate());
	}
    return messageRepository.save(message);                                
    }
    
    // DELETE
 	public void deleteMessage(Long messageId) {
 	    messageRepository.deleteById(messageId);
 	}

}
