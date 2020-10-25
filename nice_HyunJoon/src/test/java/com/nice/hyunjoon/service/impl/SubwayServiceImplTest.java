package com.nice.hyunjoon.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nice.hyunjoon.dao.SubwayDao;
import com.nice.hyunjoon.dto.Subway;
import com.opencsv.CSVReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubwayServiceImplTest {

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
	@Test
	public void getCsvFileData() throws IOException, Exception {
		//set
		String file = "data.csv";
		
		List<Subway> result = new ArrayList<>();
		
		CSVReader reader = new CSVReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/data/" + file), "euc-kr"));

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
	}

	/**
	 * 일평균 인원이 가장 많은 상위 10개의 역 명과 인원 수를 출력하는 API 개발
	 * @param rowCount
	 * @return
	 */
	@Test
	public void api1(){
		//set
		int rowCount = 10;
		
		subwayDao.dailyAvgSubway(rowCount);
	}
	
	/**
	 * 월 인원수 평균이 가장 낮은 역 명과 인원수를 출력하는 API 개발
	 * @param rowCount
	 * @return
	 */
	@Test
	public void api2(){
		//set
		int rowCount = 10;
		
		subwayDao.MonthlyAvgSubway(rowCount);
	}
	
	/**
	 * 월 인원수 최대 최소의 차이가 가장 큰 역 명을 출력하는 API 개발
	 * @param rowCount
	 * @return
	 */
	@Test
	public void api3(){
		//set
		int rowCount = 10;
		
		subwayDao.MonthlyDiffSubway(rowCount);
	}
}
