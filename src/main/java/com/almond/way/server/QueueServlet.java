package com.almond.way.server;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.almond.way.service.IDataProcessorService;

public class QueueServlet extends GenericServlet {

	private static Logger logger = Logger.getLogger(QueueServlet.class.getName());
	
	@Autowired
	@Qualifier("dataProcessorServiceImpl")
	private IDataProcessorService dataProcessor;
	
	@Override
	public void init() {
//		throw new RuntimeException("Can you see me?");
//		System.out.println("MY DEBUG: Queue Servlet initting...");
//		DefaultListableBeanFactory factory = ConfigurationUtil.loadFactory("server.xml");
//		SpringContextUtil.getBean("userService");
//    	MessageReceiver receiver = (MessageReceiver) factory.getBean("messageReceiver");
//    	Thread td = new Thread(receiver);
//    	td.start();
//	    WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
//	    MessageReceiver receiver = (MessageReceiver) wac.getBean("messageReceiver");
//	    Thread td = new Thread(receiver);
//	    td.start();
//		dataProcessor.run
	}
	
	@Override
	public void destroy() {
		
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
