package com.yedam.app.dept.service;

import java.util.List;

public interface DeptService {
	public List<DeptVO> findAll();
	
	public DeptVO findInfoDept(DeptVO deptVO);
	
	public int createInfo(DeptVO deptVO);
}
