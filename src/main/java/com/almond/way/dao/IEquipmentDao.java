package com.almond.way.dao;

import java.util.List;

import com.almond.way.model.Equipment;

public interface IEquipmentDao {
	
	int registDevice(Equipment equipment);
	
	List<Equipment> getDeviceList();
	
}
