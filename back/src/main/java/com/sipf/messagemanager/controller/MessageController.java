package com.sipf.messagemanager.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sipf.messagemanager.model.Message;
import com.sipf.messagemanager.service.MessageService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    private MessageService messageService;
    
    
    /**
	 * Create - Add a new message
	 * @body json - content, icon, link, tags, due date
	 * @return The message object saved
	 */
	@PostMapping("/message")
	public Message createMessage(@RequestBody @Valid Message message) {
		return messageService.createMessage(message);
	}
	
	/**
	 * Read - Get one message 
	 * @param id The id of the message
	 * @return An Message object full filled
	 */
	@GetMapping("/message/{id}")
	public Message getMessage(@PathVariable("id") final Long id) {
		Optional<Message> message = messageService.getMessage(id);
		if(message.isPresent()) {
			return message.get();
		} else {
			return null;
		}
	}
	
	/**
	 * Read - Get all messages
	 * @return - An Iterable object of Message full filled
	 */
	@GetMapping("/message")
	public Iterable<Message> getMessages(@RequestParam("tag") Optional<String> tag) {
		return messageService.getMessages(tag);
	}
	
	/**
	 * Delete - Delete an message
	 * @param id - The id of the message to delete
	 */
	@DeleteMapping("/message/{id}")
	public void deleteMessage(@PathVariable("id") final Long id) {
		messageService.deleteMessage(id);
	}
	
	/**
	 * Delete - Delete an message
	 * @param id - The id of the message to update
	 * @body json - content, icon, link, tags, due date
	 */
	@PutMapping(value="/message/{id}")
	public Message getMessage(@PathVariable(value = "id") Long id, @RequestBody Message message) {
	    return messageService.updateMessage(id, message);
	}

}