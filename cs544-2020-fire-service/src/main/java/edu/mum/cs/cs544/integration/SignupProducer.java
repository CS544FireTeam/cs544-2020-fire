package edu.mum.cs.cs544.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import edu.mum.cs.cs544.model.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SignupProducer {
	
	 @Autowired 
	 private JmsTemplate jmsTemplate;
	 
	 public String sendMessage(Student student) {
	    	log.info("Signup Producer> ...");
	        try {
	            jmsTemplate.convertAndSend("springbootQueue", student);
	            return "message sent!";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error in sending message!";
	        }
	 
	    }

}
