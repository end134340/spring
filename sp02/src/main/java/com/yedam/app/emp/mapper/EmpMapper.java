package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	// mapper 골격

	// 전체 조회
	public List<EmpVO> selectAll();
	
	// 단건 조회
	public EmpVO selectInfo(EmpVO empVO);
	
	// 등록과 수정 삭제는 return type이 int로 정해져있음(그 쿼리문으로 실행된 행 갯수)
	// 등록
	public int insertInfo(EmpVO empVO);
	
	// 수정
	
	
	// 삭제
}
