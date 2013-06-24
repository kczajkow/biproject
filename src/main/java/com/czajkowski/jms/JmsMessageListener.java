package com.czajkowski.jms;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.czajkowski.jms.JmsMessageProducer;
import com.czajkowski.mail.MailMail;

@Component
public class JmsMessageListener implements MessageListener { 

    private static final Logger logger = LoggerFactory.getLogger(JmsMessageListener.class);

    @Autowired
    private AtomicInteger counter = null;
    
    @Autowired
    private MailMail mailMail;

    /**
     * Implementation of <code>MessageListener</code>.
     */
    public void onMessage(Message message) {
        try {   
            int messageCount = message.getIntProperty(JmsMessageProducer.MESSAGE_COUNT);
            
            if (messageCount == 5) {
            	//logger.info("SENDING MAIL !!!");
            	//mailMail.sendMail("Krzysiek", "This is text content");
            }
            
            if (message instanceof TextMessage) {
                TextMessage tm = (TextMessage)message;
                String msg = tm.toString();
                
                logger.info("Processing message '{}'.  value={}", msg, messageCount);
                
                counter.incrementAndGet();
            }
        } catch (JMSException e) {
            logger.error(e.getMessage(), e);
        }
    }
    
}