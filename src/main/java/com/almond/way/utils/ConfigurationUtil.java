package com.almond.way.utils;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ConfigurationUtil {
	
	private final static DefaultListableBeanFactory beanFactory;
	private static XmlBeanDefinitionReader reader;
	
	static {
		beanFactory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(beanFactory);
	}

	public static DefaultListableBeanFactory loadFactory(String ...resources) {
		for (String r : resources) {
			// need validation here
			Resource resource = new ClassPathResource(r);
	    	reader.loadBeanDefinitions(resource);
	    	System.out.println("Resource loaded [" + r + "]");
		}
		return beanFactory;
	}
}
