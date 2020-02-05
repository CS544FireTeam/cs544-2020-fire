package edu.mum.cs.cs544.integration;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import edu.mum.cs.cs544.model.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignupConsumer implements MessageListener{
	
    @Override
    public void onMessage(Message message) {
        try {
        	 
        	Object obj = message.getBody(Object.class);
        	if (obj instanceof Student) {
        		Student s = (Student) obj;
        		log.info("Received message: new student sign up {} {} " , s.getFirstName(), s.getLastName());
        	}
            
        }catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

}
