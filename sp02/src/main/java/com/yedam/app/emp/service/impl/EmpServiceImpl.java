package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service // AOP (공통 기능)에 대해 지원이 가능한 Bean.
			// 예를 들어, @Transactional을 사용할 수 있는 bean.
public class EmpServiceImpl implements EmpService {

	private EmpMapper empMapper;

	@Autowired // DI : 생성자 주입 방식.
	public EmpServiceImpl(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}

	@Override
	public List<EmpVO> findAllList() {
		return empMapper.selectAll();
	}

	@Override
	public EmpVO findInfoById(EmpVO empVO) {
		return empMapper.selectInfo(empVO);
	}

	@Override
	public int createInfo(EmpVO empVO) {
		int result = empMapper.insertInfo(empVO);
		// 등록되었으면 employeeId 반환, 아니면 -1 반환.
		return result == 1 ? empVO.getEmployeeId() : -1;
	}

	@Override
	public Map<String, Object> modifyInfo(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		// String : key 역할을 할 수 있도록 세팅
		// Object : 모든 클래스의 최상위 클래스. 이렇게 선언해서 value로 받을 수 있는 클래스에 제한이 없음. boolean도 VO도 담을 수 있음.
		boolean isSuccessed = false;

		int result = empMapper.updateInfo(empVO.getEmployeeId(), empVO);

		if (result == 1) {
			isSuccessed = true;
		}

		map.put("result", isSuccessed);
		map.put("target", empVO);
		/*
		 * return type이 map인 이유는 AJAX를 위해서... 
		 * { 
		 * "result" : true, 
		 * "target" : {"employeeId" : 100, ... } 
		 * } 
		 * => javascript에서 받은 형태
		 */
		return map;
	}

	@Override
	public Map<String, Object> removeInfo(int empId) {
		Map<String, Object> map = new HashMap<>();

		int result = empMapper.deleteInfo(empId);

		if (result == 1) {
			map.put("employeeId", empId);
		}
		return map;
	}

}
