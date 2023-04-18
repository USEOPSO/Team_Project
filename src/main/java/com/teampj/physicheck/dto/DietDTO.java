package com.teampj.physicheck.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DietDTO {

	private int dietNo;      // 번호
	private String title;    // 식단명
	private String content1; // 필요성
	private String content2; // 실제
	private String content3; // 권장 식품
	private String content4; // 주의 식품
	private String content5; // 그 외 주의사항
	private String image;    // 이미지 경로
	private String image2;   // 추천 식단
	private int memberNo;    // 작성한 의사 번호
	private Date inDate;     // 작성일
	private int count;       // 조회수
	private String show;

}