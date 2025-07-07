package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest // => spring boot가 가진 컨테이너를 테스트 환경에서 사용하는 어노테이션.
class Sp02ApplicationTests {

	@Autowired // 필드 주입: 테스트용.
	private EmpMapper empMapper;
	// 스프링 입장에서는 얘가 보이면 안되지만(private이기 때문에) 억지로 필드 주입을 한 거라 실제로는 사용하지 말라고 하심. . .

	 @Test // 해당 메서드를 테스트하겠다고 선언. (이 어노테이션이 붙은 메서드만 실행됨.)
	public void selectAll() {
		List<EmpVO> list = empMapper.selectAll();
		for (EmpVO emp : list) {
			System.out.println(emp.getLastName());
		}
		// assert => 단정 메서드. 여기서만 사용할 수 있음. 매개 변수에 있는 값이 true인 것을 단정...
		assertTrue(!list.isEmpty()); // 내가 단정한 결과가 아닌 경우 에러는 아니고 failures가 뜸. 배열이 비어있지 않으면 true로 판단하겠다는 코드.
		
	}// selectAll

	@Test
	public void selectInfo() {
		EmpVO emp = EmpVO.builder().employeeId(100).build();
		// 클래스가 가진 전역 메서드인 builder를 호출(시작), 처음부터 값을 주고 싶은 필드를 선택하여 값을 넣고 인스턴스 생성.
		// build()라는 메서드 호출로 그 값을 기반으로 생성자가 돌고 인스턴스 반환(끝).
		EmpVO empInfo = empMapper.selectInfo(emp);
		System.out.println(empInfo);

		assertEquals("King", empInfo.getLastName()); // 내가 넘긴 매개값과 실행 결과가 같은지 확인
	}// selectInfo

//	@Test
	public void insertInfo() {
		EmpVO emp = EmpVO.builder().employeeId(1000)
				                   .lastName("Jung")
				                   .email("jung@choco.pie") // 유니크 제약조건이 걸려있음.
				                   .jobId("IT_PROG") // 있는 잡 아이디만 등록가능
				                   .build();

		int result = empMapper.insertInfo(emp);

		assertEquals(1, result);
	}// insert
	
//	@Test
	public void insertSelectKey() {
		EmpVO emp = EmpVO.builder()
				         .lastName("Hwa")
				         .email("hwachang@nal.ssi")
				         .jobId("ST_MAN")
//				         .salary(1200)
				         .build();
		int result = empMapper.insertInfo(emp);
		System.out.println("사원번호: " + emp.getEmployeeId());
		// emp가 가진 객체가 매개변수를 통해 selectKey의 결과가 객체 안에 들어가면 같은 값을 가지고 있으므로 함수가 종료된다고 하더라도 바깥에서 selectKey로 가져온 값 확인 가능
		assertEquals(1, result);
	}//
	
	@Test
	public void updateInfo() {
		// 1) 단건조회
		EmpVO emp = EmpVO.builder().employeeId(4322).build();
		EmpVO findVO = empMapper.selectInfo(emp);
		// 2) 값 변경
//		findVO.setSalary(2550);
		int result = empMapper.updateInfo(findVO.getEmployeeId(), findVO);
		
		assertEquals(1, result);
		
		// 3) 테이블에 업데이트
	}
	

}
