package com.almond.way.service;

/**
 * In sync data between database and Redis cache.
 * 
 * @author xuanhaoma
 *
 */
public interface IDataSyncerService {
	
	/**
	 * Fetches data from database
	 * @return
	 */
	Object fetchData();
	
	/**
	 * Updates Redis cache
	 */
	void updateRedis();

}
