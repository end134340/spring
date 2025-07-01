package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptVO;

@SpringBootTest
class Work01ApplicationTests {

	@Autowired
	private DeptMapper deptMapper;

	@Test
	public void selectAll() {
		List<DeptVO> list = deptMapper.selectList();
		for (DeptVO dept : list) {
			System.out.println(dept.getDepartmentName());
		}
		assertTrue(!list.isEmpty());
	}

	@Test
	public void selectInfo() {
		DeptVO dept = DeptVO.builder().departmentId(10).build();
		DeptVO deptInfo = deptMapper.selectInfo(dept);
		System.out.println(deptInfo);

		assertEquals("Administration", deptInfo.getDepartmentName());
	}

	@Test
	public void insertInfo() {
		DeptVO dept = DeptVO.builder().departmentName("Sales").build();
		int result = deptMapper.insertInfo(dept);

		assertEquals(1, result);
	}
}//
