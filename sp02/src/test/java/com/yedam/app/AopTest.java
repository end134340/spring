package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.aop.service.AopService;

@SpringBootTest
public class AopTest {

	@Autowired // 필드 다이렉트로 주입하는 방식. private가 동작하지 않으므로 웬만하면 사용하지 말라고,,,
	private AopService aopService;
	// proxy 패턴은 인터페이스를 기반으로 구현.

	@Test
	public void aopTest() {
		aopService.insert();
	}

}
