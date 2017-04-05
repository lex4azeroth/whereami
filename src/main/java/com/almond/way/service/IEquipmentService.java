package com.almond.way.service;

import java.util.List;

import com.almond.way.model.Equipment;

public interface IEquipmentService {
	
	int registEquipment(Equipment equipment);
	
	List<Equipment> getEquipmentList();
	
	boolean isEquipmentRegisted(String id);

}
