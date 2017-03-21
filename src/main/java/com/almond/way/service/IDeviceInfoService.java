package com.almond.way.service;

import java.util.List;
import java.util.Map;

import com.almond.way.model.DeviceLoL;

public interface IDeviceInfoService {
	
	List<DeviceLoL> getDeviceLalInfo(String deviceId, String from, String to);

}
