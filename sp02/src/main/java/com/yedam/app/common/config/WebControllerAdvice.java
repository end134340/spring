package com.yedam.app.common.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // 모든 컨트롤러에 공통적으로 적용할 사항 정의
public class WebControllerAdvice {
	// 예외처리
	// 공통 변수 선언 (spring이 가진 기능 중 컨트롤러에 전달하고자 하는 변수를 따로 선언)
	@ModelAttribute("contextPath") // 어떤 변수의 이름으로 등록할지에 대해 어노테이션을 사용. model.addAttribute를 어노테이션으로 만든 것.
	public String contextPath(final HttpServletRequest request) { // bean 객체 자체가 request를 처리하기 위한 것. 사용자가 요청하면 자동으로?
		return request.getContextPath(); // contextPath 반환.
	}
}
