package com.yedam.app.di.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yedam.app.di.SamsungTV;
import com.yedam.app.di.SonySpeaker;

// @Configuration => Spring 설정이라는 걸 알리는 어노테이션. 
//  따로 이 메서드들을 호출하지 않아도 configuration이 붙은 클래스 안의 메서드들을 순차적으로 실행시킴.
@Configuration
public class JavaConfig { //java 방식으로는 처음부터 끝까지 다 컴파일하지만 xml을 사용해서 제대로 읽어오지 못해 에러를 일으키는 것보다는 낫다?고?생각하는건가?
	// bean을 등록하는 방식이 메서드를 선언?하는 방식
	// xml의 bean 태그 하나가 java방식에서는 @Bean 하나
	
	@Bean // 메서드를 실행한 결과(return 하는 대상)를 bean으로 등록하겠다는 뜻.
	public SonySpeaker createSonySpeaker() {
		return new SonySpeaker();
	}

	@Bean // 완성된 tv를 bean으로 등록.
	SamsungTV createSamsungTV(SonySpeaker speaker) {
		//위에서 SonySpeaker를 기반으로 bean을 생성한 것을 매개변수로 강제로 넣어버림.
		// 생성자로 하든 세터를 사용하든 크게 상관은 없음.
		
		// 1) 생성자 주입.
//		SamsungTV tv = new SamsungTV(speaker);
		// 2) setter 주입
		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(speaker);
		
		return tv;
	}

}//
