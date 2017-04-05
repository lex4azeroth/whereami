package com.almond.way.service.impl;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.almond.way.model.DeviceInfo;
import com.almond.way.server.WhereAmIController;
import com.almond.way.service.IPublisherService;

@Service()
public class PublisherServiceImpl implements IPublisherService {

	private static Logger logger = Logger.getLogger(PublisherServiceImpl.class.getName());
	
	@Autowired()
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	@Autowired()
	@Qualifier("destination")
	private Destination destination;
	
	public void postPosition(float x, float y) {
		// post x, y to queue
		
	}

	@Override
	public synchronized void doPost(final DeviceInfo deviceInfo) {
		String text = String.format("POST:[%s]", deviceInfo.toString());
		logger.info(text);	
		jmsTemplate.convertAndSend(destination, deviceInfo);
	}
}
