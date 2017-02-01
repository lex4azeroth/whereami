package com.almond.way.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.almond.way.dao.IDeviceInfoDao;
import com.almond.way.model.DeviceInfo;
import com.almond.way.service.IDataProcessorService;

@Service
public class DataProcessorServiceImpl implements IDataProcessorService {

	@Resource
	private IDeviceInfoDao deviceInfoDao;

	@Override
	public boolean processData(String dataInString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String processDeviceLocation(DeviceInfo deviceInfo) {
		deviceInfoDao.addDeviceInfo(deviceInfo);
		DeviceInfo retrievedDevice = deviceInfoDao.getDeviceInfo(deviceInfo);
		return retrievedDevice.getAndroidID();
	}
}
