package com.almond.way.server;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ServletProxy extends GenericServlet {
	
	private String targetBean;
	private Servlet proxy;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.targetBean = getServletName();
        getServletBean();
        proxy.init(getServletConfig());
	}
	
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		proxy.service(arg0, arg1);
	}
	
	private void getServletBean() {
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.proxy = (Servlet) wac.getBean(targetBean);//get proxyBean
	}

}