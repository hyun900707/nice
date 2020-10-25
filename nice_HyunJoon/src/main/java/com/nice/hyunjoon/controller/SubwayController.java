package com.nice.hyunjoon.controller;

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
    private ResponseEntity<?> upload() {    	
    	HashMap<String, Object> result = new HashMap<>();
    	
    	try {
			result.put("count", subwayService.getCsvFileData("data.csv"));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
    	
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value="/api1", method=RequestMethod.GET)
	private ResponseEntity<?> api1(@RequestParam("count") int count) {		
		HashMap<String, Object> result = new HashMap<>();
		
		try {
			result.put("data", subwayService.api1(count));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api2", method=RequestMethod.GET)
	private ResponseEntity<?> api2(@RequestParam("count") int count) {		
		HashMap<String, Object> result = new HashMap<>();
		
		try {
			result.put("data", subwayService.api2(count));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api3", method=RequestMethod.GET)
	private ResponseEntity<?> api3(@RequestParam("count") int count) {		
		HashMap<String, Object> result = new HashMap<>();
		
		try {
			result.put("data", subwayService.api3(count));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
