package com.nice.hyunjoon.service.impl;

import com.nice.hyunjoon.dao.SubwayDao;
import com.nice.hyunjoon.dto.Subway;
import com.nice.hyunjoon.service.SubwayService;
import com.opencsv.CSVReader;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Log4j2
public class SubwayServiceImpl implements SubwayService{
	private static final int LOOP_START = 3;
	private static final int MONTH_INDEX = 12;
	private static final int START_INSTITUTION_INDEX = 2;
	
	@Autowired
	SubwayDao subwayDao;

	/**
	 * 데이터파일(.csv)의 각 레코드를 데이터베이스에 저장하는 API 개발
	 * @param file
	 * @return
	 * @throws IOException, Exception 
	 * @throws Exception
	 */
	@Override
	public int getCsvFileData(String file) throws IOException, Exception {
		List<Subway> result = new ArrayList<>();
		
		CSVReader reader = new CSVReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/data/" + file), "euc-kr"));

		log.info("file : " + file);
		log.info("START_INSTITUTION_INDEX : " + START_INSTITUTION_INDEX);

		String[] nextLine;
		reader.skip(START_INSTITUTION_INDEX - 1);
		
		// Pivot 데이터 정규화하여 DB화
		while ((nextLine = reader.readNext()) != null) {
			for (int i = LOOP_START; i < MONTH_INDEX; i++) {
				result.add(Subway.builder()
						.line(nextLine[0])
						.name(nextLine[2])
						.month(i - LOOP_START + 1)
						.amount(Integer.parseInt(nextLine[i].replaceAll("\\,", "")))
						.build());
			}
		}
		
		// Parsing 성공시 DB화
		subwayDao.truncateSubway(); // 과거데이터 삭제

		result.forEach(item -> subwayDao.insertSubway(item));
		

		return result.size();
	}

	/**
	 * 일평균 인원이 가장 많은 상위 10개의 역 명과 인원 수를 출력하는 API 개발
	 * @param rowCount
	 * @return
	 */
	@Override
	public List<HashMap<String, Object>> api1(int rowCount){
		return subwayDao.dailyAvgSubway(rowCount);
	}
	
	/**
	 * 월 인원수 평균이 가장 낮은 역 명과 인원수를 출력하는 API 개발
	 * @param rowCount
	 * @return
	 */
	@Override
	public List<HashMap<String, Object>> api2(int rowCount){
		return subwayDao.MonthlyAvgSubway(rowCount);
	}
	
	/**
	 * 월 인원수 최대 최소의 차이가 가장 큰 역 명을 출력하는 API 개발
	 * @param rowCount
	 * @return
	 */
	@Override
	public List<HashMap<String, Object>> api3(int rowCount){
		return subwayDao.MonthlyDiffSubway(rowCount);
	}
}
