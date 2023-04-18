package com.teampj.physicheck.vue.vo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "reserve")
@NoArgsConstructor
public class ReserveVO {

	@Id
	private int reserveno;            // 예약번호
	private int memberno;            // 회원번호
    private String id;      //회원명
	private Timestamp reservedate;      // 예약일
	private Integer paystate;            // 결제 상태
	private Integer basicno;            // 기초검사번호
	private Integer physicalno;            // 운동검사번호
	private Integer mentalno;            // 심리검사번호
	private Integer reviewstate;         // 리뷰 작성 여부
    private String bshow;      // 기본검사 등록 완료시 bshow='n'
    private String pshow;      // 운동검사 등록 완료시 pshow='n'
    private String mshow;      // 심리검사 등록 완료시 mshow='n'
}