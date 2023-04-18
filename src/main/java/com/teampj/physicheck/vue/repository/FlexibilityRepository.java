package com.teampj.physicheck.vue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teampj.physicheck.vue.vo.FlexibilityVO;

public interface FlexibilityRepository extends JpaRepository<FlexibilityVO, Integer>{}