package com.wanted.domain;

import lombok.Data;

@Data
public class BoardVO {
	
	private Long bno;
	private String company_id;
	private String position;
	private int pay;
	private String content;
	private String tech;

}
