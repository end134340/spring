package com.yedam.app.aop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AopMapper;

import lombok.RequiredArgsConstructor;

@Service // AOP(관심분리) 기능을 적용할 수 있는 대상
@RequiredArgsConstructor // Lombok을 활용한 생성자 주입 방식
public class AopServiceImpl implements AopService {

	// Lombok을 활용한 생성자 주입 방식
	private final AopMapper aopMap;

	@Transactional // 메서드에서 사용될 경우 메서드 안에서 몇 개의 쿼리문이 사용되든 상관 없이 하나의 트랜잭션으로 묶임을 선언하는 어노테이션.
	// 원하면 다양한 기능을 추가할 수 있음. timeout => 다른 사람이 이미 트랜잭션을 발생시킨 상황이면 내 트랜잭션이 딜레이가 걸리는데 지정한 시간 이상 트랜잭션이 시작되지 않으면 종료 후 알림.
	@Override
	public void insert() {
		aopMap.insert("101"); // commit
		aopMap.insert("a101"); // error로 인해 rollback
	}

}
