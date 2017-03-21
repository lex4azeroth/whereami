package com.almond.way.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.almond.way.dao.IDeviceInfoDao;
import com.almond.way.model.DeviceLoL;
import com.almond.way.service.IDeviceInfoService;

@Service
public class DeviceInfoServiceImpl implements IDeviceInfoService {

	@Resource
	private IDeviceInfoDao deviceInfoDao;
	
	private static Logger logger = Logger.getLogger(DeviceInfoServiceImpl.class.getName());
	
	@Override
	public List<DeviceLoL> getDeviceLalInfo(String deviceId, String from, String to) {
		logger.info("deviceId is [" + deviceId + "]");
		logger.info("from is [" + from + "]");
		logger.info("to is [" + to + "]");
		logger.info("before get");
		List<DeviceLoL> resultMap = deviceInfoDao.getDeviceLaL(deviceId, from, to);
		logger.info("after get");
		if (resultMap != null) {
			logger.info("resultMap not null " + resultMap.getClass().getName().toString());
			logger.info("quired size [" + resultMap.size() + "]");
			for (DeviceLoL dlol : resultMap) {
				logger.info("id is [" + dlol.getId() + "]");
				logger.info("latitude is [" + dlol.getLatitude() + "]");
				logger.info("longitude is [" + dlol.getLongitude() + "]");
			}
			
			return resultMap;
		} else {
			logger.error("resultmap is null");
		}
		
		return null;
	}

}
