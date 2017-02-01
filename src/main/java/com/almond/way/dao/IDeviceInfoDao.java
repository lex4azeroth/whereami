package com.almond.way.dao;

import com.almond.way.model.DeviceInfo;

public interface IDeviceInfoDao {
	
	DeviceInfo getDeviceInfo(DeviceInfo deviceInfo);
	
	void addDeviceInfo(DeviceInfo deviceInfo);

}
