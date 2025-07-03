package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@Controller
// DispatcherServlet(FrontController)이 활용하는 정보를 등록하는 Bean
// route: 사용자의 요청(endpoint=uri+method)와 그에 대한 처리. 
//        즉,  URI + HTTP METHOD => Service => Response(View or Data)
@RequiredArgsConstructor // final로 선언되어있는 걸 기반으로 생성자를 만들어주는 어노테이션. (lombok을 기반으로 생성자를 생성하는 방식)
public class EmpController {
	// 해당 컨트롤러에서 제공하는 서비스 목록.
	private final EmpService empService;

	// GET: 조회, 빈페이지, 데이터 조작(삭제)
	// POST: 데이터 조작(등록, 수정)
	// 기능을 정상적으로 수행하기 위해 매핑되는 경로는 기능보다 늘어날 수도 있고, 줄어들 수도 있음.

	// 전체 조회: GET
	@GetMapping("empList") // 1) URI + METHOD 설정.
	public String empList(Model model) {
		// 2) 수행 기능 설정 => service
		List<EmpVO> list = empService.findAllList();
		// 2-1) View에 전달할 데이터 담기(model은 그런 용도로 사용됨. req인지 res인지 구분하기 어려워서 spring이 알아서
		// 처리해줄테니 model에 담기만 하면 됨.)
		model.addAttribute("emps", list);

		// 3) 응답 형태 설정(View)
		return "emp/list"; // => return되는 형태를 중심으로 prefix에 해당되는 classpath:/template/가 앞에 붙고, 끝에 suffix로 .html이 붙는 형태.
		// emp가 붙는 이유는 각 페이지를 용도별로 활용하기 위해 폴더 개념?으로? emp를 집어넣음.
	}

	// 단건 조회: GET => queryString
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findInfoById(empVO); // 여기서 요구하는 게 객체이기 때문에 커맨드 객체로 받음. 넘기는 게 하나면 RequestParam.
		model.addAttribute("emp", findVO);
		return "emp/info";
	}

	// 등록 - 페이지: GET
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}

	// 등록 - 처리: POST => 등록은 AJAX를 거의 안 씀. <form> 태그의 submit 활용하는 경우 많음. / QueryString
	@PostMapping("empInsert") // 페이지와 처리는 같은 경로를 공유함.
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.createInfo(empVO);
		String url = null;
		if (eid > -1) {
			// 정상적으로 등록.
			url = "redirect:empinfo?employeeId=" + eid; // 등록하면서 생성된 id값 넘겨줌
		} else {
			// 등록되지 않은 경우
			url = "redirect:empList"; // 실행되지 않을 코드(에러가 나서 중단될거기 때문에...)
		}
		return url;
	}

	// 수정 - 페이지: GET <=> 단건조회(비밀번호를 제외하고는 실제로 수정하고자 하는 데이터가 보여야 함.)
	@GetMapping("empUpdate")
	public String empUpdateForm(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findInfoById(empVO); // 여기서 요구하는 게 객체이기 때문에 커맨드 객체로 받음. 넘기는 게 하나면 RequestParam.
		model.addAttribute("emp", findVO);
		return "emp/update";
	}
	
	// 수정 - 처리: POST + AJAX + JSON
	@PostMapping("empUpdate")
	@ResponseBody // AJAX를 기반으로 해서 동작시키겠다고 선언하는 어노테이션. => 보내는 데이터가 텍스트나 배열 기타 등등일 수 있음.
	public Map<String, Object> empUpdateProcess(@RequestBody EmpVO empVO) { // 사용자에게서 JSON포맷으로 받겠다고 선언하는 어노테이션.
		return empService.modifyInfo(empVO); //AJAX를 사용하는 경우 model 객체를 사용할 수 없음. AJAX는 페이지가 생성되지 않기?때문에. . .
	}
	

	// 삭제 - 처리: GET (중요한 정보가 딸려오는 경우에는 post로. 일반적인 경우에는 보통 get으로 함.) => QueryString
	@GetMapping("empDelete") 
	public String empDelete(Integer employeeId) {
		empService.removeInfo(employeeId);		
		return "redirect:empList"; // 삭제된 데이터는 더이상 사용자 눈에 보이면 안되기 때문에 없는 데이터를 보일 수 없기 때문에 전체 조회 페이지로 돌림. 
	}

}
