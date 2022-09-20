package com.sipf.messagemanager;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sipf.messagemanager.model.Message;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerTest {
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetMessages() throws Exception {
        mockMvc.perform(get("/api/message"))
            .andExpect(status().isOk());
    }
    
    @Test
    public void testCreateWithoutContent() throws Exception {
    	Message message = new Message();
    	ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(message);
    	
        mockMvc.perform(post("/api/message").contentType(APPLICATION_JSON_UTF8)
            .content(requestJson))
            .andExpect(status().is(400));
    }
    
    @Test
    public void testScriptInjectionInContent() throws Exception {
    	Message message = new Message();
    	message.setContent("<script>alert('xss');<\script>");
    	ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(message);
    	
        mockMvc.perform(post("/api/message").contentType(APPLICATION_JSON_UTF8)
            .content(requestJson))
            .andExpect(status().is(400));
    }
    
    @Test
    public void testCreateMessage() throws Exception {
    	Message message = new Message();
    	message.setContent("Some beautiful message");
    	ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(message);
    	
        mockMvc.perform(post("/api/message").contentType(APPLICATION_JSON_UTF8)
            .content(requestJson))
            .andExpect(status().is(200))
            .andExpect(jsonPath("$.creationTime", notNullValue()))
        	.andExpect(jsonPath("$.lastUpdate", notNullValue()));
    }
    
    @Test
    public void testUpdateMessage() throws Exception {
    	Message message = new Message();
    	message.setLink("https://google.com");
    	ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(message);
    	
        mockMvc.perform(put("/api/message/1").contentType(APPLICATION_JSON_UTF8)
            .content(requestJson))
            .andExpect(status().is(200))
            .andExpect(jsonPath("$.creationTime", not(equalTo(jsonPath("$.lastUpdate")))));
    }

}