package com.yedam.app.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	// AJAX(통신을 했을 때 페이지 전체를 받지 않고 순수하게 데이터만 가지고 와서 화면을 부분 수정하는 목적(화면의 리로드가 발생하지않음))
	public String commandObject(EmpVO empVO) {
		String result = "";
		result += "Path: /comobj <br>";
		result += "\t employee_id: " + empVO.getEmployeeId();
		result += "\t last_name: " + empVO.getLastName();
		return result;
	}

	// QueryString, 2) @RequestParam (기본값) <- 기본값이지만 기본타입을 사용하지는 않고 Integer 등과 같은 참조 타입(wrap class) 사용. null값이 넘어올 때가 있기 때문. 단일 값.
	@RequestMapping("reqparm")
	@ResponseBody
	public String requestParam(@RequestParam Integer employeeId, // 필수 (값이 안 들어오면 오류가 남)
			String lastName) { // 생략 가능 (값이 안 들어와도 오류가 안 남)
		String result = "";
		result += "Path: /reqparm <br>";
		result += "\t employee_id: " + employeeId;
		result += "\t last_name: " + lastName;
		return result;
	}
	
	// @PathVariable : 경로에 값을 포함하는 방식, 객체가 아닌 단일 값. payload가 안 뜸. spring도 RestAPI를 만들 수 있음.
	// Method는 상관없음 (경로에 매핑되기 때문에)
	// Content-type도 상관없음 (경로에 매핑되기 때문에)
	@RequestMapping("path/{id}") // {} => pathVariable이 매칭되는 위치
	@ResponseBody
	public String pathVariable(@PathVariable String id) {
		String result = "";
		result += "Path: /path/{id} <br>";
		result += "\t id: " + id;
		return result;
	}
	
	// @RequestBody : JSON 포맷, 배열 or 객체 @ResponseBody와 같은 대상을 처리. Request는 받을 때(매개변수로 사용), Response는 돌려줄 때(return타입).
	// Method : POST, PUT => body가 반드시 필요한 어노테이션이기 때문에. . . get은 body가 없으므로 안됨
	// Content-type : application/json
	@PostMapping("resbody")
	@ResponseBody
	public EmpVO requestBody(@RequestBody EmpVO empVO) { // 필드 값들로 구성을 해야함.
		return empVO;
	}
	
	//배열을 주고받을 때. JSON은 편리하지만 보낼 때 객체 하나를 보내거나 배열 하나를 보내거나 해야함.
	@PostMapping("resbodyList")
	@ResponseBody
	public List<EmpVO> requestBodyList(@RequestBody List<EmpVO> list) { // 필드 값들로 구성을 해야함.
		return list;
	}
	

}//
