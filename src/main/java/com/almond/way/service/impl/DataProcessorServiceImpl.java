package com.almond.way.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.almond.way.dao.IDeviceInfoDao;
import com.almond.way.model.DeviceInfo;
import com.almond.way.model.Equipment;
import com.almond.way.service.IDataProcessorService;
import com.almond.way.service.IEquipmentService;

@Service
public class DataProcessorServiceImpl implements IDataProcessorService {

	@Resource
	private IDeviceInfoDao deviceInfoDao;
	
	@Autowired
	@Qualifier("equipmentServiceImpl")
	private IEquipmentService equipmentService;

	@Override
	public boolean processData(String dataInString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void processDeviceLocation(DeviceInfo deviceInfo) {
		
//		if (!equipmentService.isEquipmentRegisted(deviceInfo.getAndroidID())) {
//			Equipment equ = new Equipment();
//			equ.setEquipmentId(deviceInfo.getAndroidID());
//			String defaultName = String.format("default_name_%s", deviceInfo.getAndroidID());
//			equ.setEquipmentName(defaultName);
//			equipmentService.registEquipment(equ);
//		}
		
		deviceInfoDao.addDeviceInfo(deviceInfo);
	}
}
