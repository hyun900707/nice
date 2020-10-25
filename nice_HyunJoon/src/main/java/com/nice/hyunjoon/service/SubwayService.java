package com.nice.hyunjoon.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface SubwayService {
	public HashMap<String, Object> getCsvFileData(String file) throws IOException, Exception;

	public List<HashMap<String, Object>> api1(int rowCount);

	public List<HashMap<String, Object>> api2(int rowCount);

	public List<HashMap<String, Object>> api3(int rowCount);
}
