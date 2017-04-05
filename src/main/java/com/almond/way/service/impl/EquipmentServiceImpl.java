package com.almond.way.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.almond.way.dao.IEquipmentDao;
import com.almond.way.model.Equipment;
import com.almond.way.service.IEquipmentService;

@Service
public class EquipmentServiceImpl implements IEquipmentService {

	private static Logger logger = Logger.getLogger(EquipmentServiceImpl.class.getName());

	@Resource
	private IEquipmentDao equipmentDao;
	
	private List<Equipment> equipmentsInCache; 

	@Override
	public synchronized int registEquipment(Equipment equipment) {
		Objects.requireNonNull(equipment);
		int id = equipmentDao.registDevice(equipment);
		equipment.setId(id);
		equipmentsInCache.add(equipment);
		logger.info("Now we have [" + equipmentsInCache.size() + "] equipments in cache.");
		return id;
	}

	@Override
	public synchronized List<Equipment> getEquipmentList() {
		if (equipmentsInCache == null || equipmentsInCache.isEmpty()) {
			logger.info("Equipment # in cache is 0");
			equipmentsInCache = equipmentDao.getDeviceList();
		}
		
		logger.info("After query, Now we have [" + equipmentsInCache.size() + "] equipments in cache.");

		return equipmentsInCache;
	}

	@Override
	public synchronized boolean isEquipmentRegisted(String id) {
		logger.info(String.format("Is device %s registerd in cache?", id));
		for (Equipment equ : getEquipmentList()) {
			if (equ.getEquipmentId().equals(id)) {
				logger.info("Equipment [" + id + "] registed in cache.");
				return true;
			}
		}
		
		logger.info("Equipment [" + id + "] not registed in cache.");
		return false;
	}
}
