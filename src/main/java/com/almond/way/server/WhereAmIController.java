package com.almond.way.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.almond.way.model.DeviceInfo;
import com.almond.way.model.DeviceLoL;
import com.almond.way.model.Equipment;
import com.almond.way.model.LoginUser;
import com.almond.way.service.IDeviceInfoService;
import com.almond.way.service.IEquipmentService;
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
	
	@Autowired
	@Qualifier("deviceInfoServiceImpl")
	private IDeviceInfoService deviceInfoService;
	
	@Autowired
	@Qualifier("equipmentServiceImpl")
	private IEquipmentService equipmentService;

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
		
		String returnValue = String.format("%d records POSTED", index);
		logger.info("RETURN VALUE: " + returnValue);
		return returnValue;
	}
	
	@RequestMapping(value="/ihavebeen", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<DeviceLoL> getDeviceLals() {
		logger.info("i have been...");
		List<DeviceLoL> deviceLoLs = deviceInfoService.getDeviceLalInfo("7bbd793805f2ba1d", "2017-02-12 02:09:51", "2017-02-12 02:56:59");
		Map<String, String> map = new HashMap<String, String>();
		return deviceLoLs;
	}
	
	@RequestMapping(value="/testmylocation", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE) 
    @ResponseBody
	public String postTestDeviceLocation(@RequestBody DeviceInfo deviceInfos) {
		logger.info("postTestDeviceLocation...");
		
		return String.format("posted device [%s]", deviceInfos.toString());
	}
	
	@RequestMapping(value="/equipments", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Equipment> getEquipmentList() {
		logger.info("getting equipment list...");

		return equipmentService.getEquipmentList();
	}
}
