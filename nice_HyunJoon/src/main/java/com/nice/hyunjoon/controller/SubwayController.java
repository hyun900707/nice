package com.nice.hyunjoon.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nice.hyunjoon.service.impl.SubwayServiceImpl;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping(value="/v1.0")
public class SubwayController {
    
	@Autowired
	SubwayServiceImpl subwayService;

	@RequestMapping(value="/file", method=RequestMethod.GET)
    private ResponseEntity<?> upload(@RequestParam(value="file", required=false, defaultValue="data.csv") String file) {    	
    	HashMap<String, Object> result = new HashMap<>();
    	
    	try {
			result.put("data", subwayService.getCsvFileData(file));
			result.put("status", "sucess");
			result.put("code", "0");
		} catch (IOException e) {
			log.error(e.getMessage());
			result.put("status", "Not Found File");
			result.put("code", "1");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error(e.getMessage());
			result.put("status", "Invalid File");
			result.put("code", "2");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
    	
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value="/api1", method=RequestMethod.GET)
	private ResponseEntity<?> api1(@RequestParam(value="count", required=false, defaultValue="10") int count) {		
		HashMap<String, Object> result = new HashMap<>();
		
		try {
			result.put("data", subwayService.api1(count));
			result.put("status", "sucess");
			result.put("code", "0");
		} catch (Exception e) {
			log.error(e.getMessage());
			result.put("status", "DB Fail");
			result.put("code", "1");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api2", method=RequestMethod.GET)
	private ResponseEntity<?> api2(@RequestParam(value="count", required=false, defaultValue="1") int count) {		
		HashMap<String, Object> result = new HashMap<>();
		
		try {
			result.put("data", subwayService.api2(count));
			result.put("status", "sucess");
			result.put("code", "0");
		} catch (Exception e) {
			log.error(e.getMessage());
			result.put("status", "DB Fail");
			result.put("code", "1");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api3", method=RequestMethod.GET)
	private ResponseEntity<?> api3(@RequestParam(value="count", required=false, defaultValue="1") int count) {		
		HashMap<String, Object> result = new HashMap<>();
		
		try {
			result.put("data", subwayService.api3(count));
			result.put("status", "sucess");
			result.put("code", "0");
		} catch (Exception e) {
			log.error(e.getMessage());
			result.put("status", "DB Fail");
			result.put("code", "1");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
