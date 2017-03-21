package com.almond.way.service;

import com.almond.way.model.DeviceInfo;

public interface IDataProcessorService {
	
	boolean processData(String dataInString);
	
	void processDeviceLocation(DeviceInfo deviceInfo);

}
