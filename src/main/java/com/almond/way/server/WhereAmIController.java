package com.almond.way.server;

import java.util.Calendar;
import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.almond.way.model.DeviceInfo;
import com.almond.way.model.LoginUser;
import com.almond.way.service.ILoginUserService;
import com.almond.way.service.IPublisherService;

@Controller
@RequestMapping("/way")
public class WhereAmIController {
	
	private static Logger logger = Logger.getLogger(WhereAmIController.class.getName());
	
	@Autowired
	@Qualifier("publisherServiceImpl")
	private IPublisherService publisher;
	
	@Autowired
	@Qualifier("loginUserServiceImpl")
	private ILoginUserService loginUserService;

	@RequestMapping(value="/")
	public String homeSweetHome() {
		return "index";
	}
	
	@RequestMapping(value="/sayhi", method=RequestMethod.GET)
	public ModelAndView sayHi() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("whereami");
		logger.debug("can you see me? Hi THERE");
		return mav;
	}
	
	@RequestMapping(value="/loginuser")
	@ResponseBody
	public String getLoginUser() {
		LoginUser user = loginUserService.getLoginUserById("USR_01", "pwd");
		logger.info("Get Login User:");
		logger.info(user.getAlias());
		
		return user.getAlias();
	}
	
	@RequestMapping(value="/mylocation", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE) 
    @ResponseBody
	public String postDeviceLocation(@RequestBody List<DeviceInfo> deviceInfos) {
		logger.info("postDeviceLocation...");
		int index = 0;
		for (; index < deviceInfos.size(); index++) {
			logger.info(String.format("Lat[%s]", deviceInfos.get(index).getLatitude()));
			publisher.doPost(deviceInfos.get(index));
		}
		
		return String.format("[%d] records posted", index);
	}
	
	@RequestMapping(value="/testmylocation", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE) 
    @ResponseBody
	public String postTestDeviceLocation(@RequestBody DeviceInfo deviceInfos) {
		logger.info("postTestDeviceLocation...");
		
		return String.format("posted device [%s]", deviceInfos.toString());
	}
	
	@RequestMapping(value="/mockpost", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String mockPost(@RequestBody List<DeviceInfo> deviceInfos) {
		logger.info("[MOCK POST]");
		int index = 0;
		for (; index < deviceInfos.size(); index++) {
			logger.info(String.format("Lat[%s]", deviceInfos.get(index).getLatitude()));
			logger.info(String.format("[MOCK POSTED] %s", deviceInfos.get(index).toString()));
		}
		
		return String.format("%d records POSTED", index);
	}
	
	@RequestMapping(value="/lal/{id}")
	@ResponseBody
	public String postLaL(@PathVariable("id") Integer id) {
		
		// For test only
		DeviceInfo deviceInfo = new DeviceInfo();
		deviceInfo.setAndroidID("EQUID" + id.toString());
		deviceInfo.setLatitude("testlat");
		deviceInfo.setLongitude("testlon");
		deviceInfo.setDate(Calendar.getInstance().getTime().toString());
		
		// post it to active message queue.
		publisher.doPost(deviceInfo);
		return String.format("Device [%d] posted", id);
		
	}

}
