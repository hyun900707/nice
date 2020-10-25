package com.nice.hyunjoon.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Subway {

	private String line;
	private String name;
	private int month;
	private int amount;
	
}
