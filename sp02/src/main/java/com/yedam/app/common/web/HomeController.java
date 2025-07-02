package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* 
 * route = Endpoint(URL + Http Method) -> handler mapping
 *         + Service
 *         + 응답형태(View or Data)
*/
@Controller
public class HomeController {

	// 메서드 하나가 하나의 라우트에 대응되는 형태.
	// 메인 페이지 호출 라우터.
//	@RequestMapping("/") //경로 매핑 어노테이션. request별로 처리? => spring?에서는? 별로?권장하지 않는 방식?
	public String mainPage(String message, Model model) {
		// message = 사용자로부터 우리가 받을 수 있는 값. request에 담긴 값.
		// model = 스프링 고유 객체. request와 response를 내부적으로 처리할 때 사용. Request + Response

		// service 실행
		model.addAttribute("msg", message); // = req.setAttribute() "페이지에서 사용하는 변수 값", 담을 값.
		return "home"; // classpath:/template/home.html 이걸 화면으로 사용하겠다고 선언되어 있는거.
	}

	// 같은 경로에 대해 get/post mapping으로 나눔.
	// 동일한 경로에 대해 같은 메소드가 있으면 에러가 남.

	@GetMapping("/")
	public String mainPage() {
		return "home";
	}

	@PostMapping("/")
	public String mainMsgPage(String message, Model model) {
		model.addAttribute("msg", message);
		return "home";
	}
}
