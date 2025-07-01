package com.yedam.app.dept.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeptVO {
	private Integer departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
}
