package com.yedam.app.dept.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DeptController {

	private final DeptService deptService;

	@GetMapping("deptList")
	public String DeptList(Model model) {
		List<DeptVO> list = deptService.findAll();
		model.addAttribute("deptList", list);
		return "dept/list";
	}

	@GetMapping("deptInfo")
	public String deptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.findInfoDept(deptVO);
		model.addAttribute("dept", findVO);
		return "dept/info";
	}

	// 등록폼
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}

	// 등록처리
	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO deptVO) {
		int result = deptService.createInfo(deptVO);
		String url = null;
		if (result > 0) {
			url = "redirect:deptList";
		} else {
			url = "redirect:deptList";
		}
		return url;
	}
}
