package com.almond.way.utils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.JmsException;

import com.almond.way.model.DeviceInfo;
import com.almond.way.service.IDataProcessorService;

public class QueueMessageListener implements MessageListener {
	private static Logger logger = Logger.getLogger(QueueMessageListener.class.getName());
	
	@Autowired
	@Qualifier("dataProcessorServiceImpl")
	private IDataProcessorService dataProcessor;
	
	@Override
	public void onMessage(Message message) {
		
		if (message instanceof ObjectMessage) {
			ObjectMessage objMessage = (ObjectMessage) message;
			try {
				Object obj = objMessage.getObject();
				DeviceInfo deviceInfo = (DeviceInfo) obj;
				logger.info("Porceeding...[" + deviceInfo.toString() + "]");
				dataProcessor.processDeviceLocation(deviceInfo);   
			} catch (JMSException ex) {
				logger.error(ex.getMessage().toString());
			}
		}
		
//		if (message != null) {
//			DeviceInfo deviceInfo = (DeviceInfo) message;
//			logger.info("Porceeding...[" + deviceInfo.toString() + "]");
//			dataProcessor.processDeviceLocation(deviceInfo);    			
//		} else {
//			logger.info("No message received...");
//		}
		
//		try {
//    		DeviceInfo deviceInfo = (DeviceInfo) message;
//    		if (deviceInfo != null) {
//    			logger.info("Porceeding...[" + deviceInfo.toString() + "]");
//    			dataProcessor.processDeviceLocation(deviceInfo);    			
//    		} else {
//    			logger.info("No message received...");
//    		}
//		} catch (JMSException e) {
//			e.printStackTrace();
//		}
	}

}
