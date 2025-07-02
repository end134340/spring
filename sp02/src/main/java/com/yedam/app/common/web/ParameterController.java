package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@CrossOrigin(origins = "*") // ajax 사용으로 인해 CORS 설정. 간단한 테스트할때는 사용해도 괜찮음
// origins= = "*" -> 모든 origin에 대해 접근 허용.
@Controller
public class ParameterController {
	// QueryString(질의문자열) : key=value&key=value&...
	// Content-type : application/x-www-form-urlencoded
	// Method : 상관없음

	// QueryString, 1) 커맨드 객체. (어노테이션을 사용하지 않고 객체로 선언되는 것)
	@RequestMapping("comobj")
	@ResponseBody // 응답하는 형태를 화면이 아니라 순수 데이터를 가지고 넘길때? 사용하는 어노테이션
	// AJAX(통신을 했을 때 페이지 전체를 받지 않고 순수하게 데이터만 가지고 와서 화면을 부분 수정하는 목적(화면의 리로드가 발생하지 않음)), , , 
	public String commandObject(EmpVO empVO) {
		String result = "";
		result += "Path: /comobj \n";
		result += "\t employee_id: " + empVO.getEmployeeId();
		result += "\t last_name: " + empVO.getLastName();
		return result;
	}

}//
