package com.almond.way.service.impl;

import java.util.Objects;

import javax.annotation.Resource;

import com.almond.way.dao.IEquipmentDao;
import com.almond.way.model.Equipment;
import com.almond.way.service.IEquipmentService;

public class EquipmentServiceImpl implements IEquipmentService {

	@Resource
	private IEquipmentDao equipmentDao;

	@Override
	public int registEquipment(Equipment equipment) {
		Objects.requireNonNull(equipment);
		return equipmentDao.registDevice(equipment);
	}
}
