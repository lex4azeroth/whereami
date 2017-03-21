package com.almond.way.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.almond.way.model.DeviceInfo;
import com.almond.way.model.DeviceLoL;

public interface IDeviceInfoDao {
	
	DeviceInfo getDeviceInfo(DeviceInfo deviceInfo);
	
	List<DeviceLoL> getDeviceLaL(@Param("deviceId") String deviceId, @Param("from") String from, @Param("to") String to);
	
	Map<String, Object> getDeviceLaLById(@Param("deviceId") String deviceId);
	
	void addDeviceInfo(DeviceInfo deviceInfo);

}
