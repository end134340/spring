package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	public int updateInfo(@Param("id") int eid, @Param("info") EmpVO empVO);
	//@Param("변수명") 에서 선언한 변수명은 mapper.xml에서 사용할 변수명.

	// 삭제
	public int deleteInfo(int employeeId);
}
