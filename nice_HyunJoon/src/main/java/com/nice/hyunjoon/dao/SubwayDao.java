package com.nice.hyunjoon.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.nice.hyunjoon.dto.Subway;

@Repository
@Mapper
public interface SubwayDao {

	/**
	 * Subway Table Truncate
	 * @return
	 */
	Integer truncateSubway();

	/**
	 * Subway data Insert
	 * @return
	 */
	Integer insertSubway(Subway subway);

	/**
	 * Get Subway Daily Average 
	 * @param rowCount
	 * @return
	 */
	List<HashMap<String, Object>> dailyAvgSubway(int rowCount);

	/**
	 * Get Subway Monthly Average 
	 * @param rowCount
	 * @return
	 */
	List<HashMap<String, Object>> MonthlyAvgSubway(int rowCount);

	/**
	 * Get Subway Monthly Max - Min 
	 * @param rowCount
	 * @return
	 */
	List<HashMap<String, Object>> MonthlyDiffSubway(int rowCount);
}
