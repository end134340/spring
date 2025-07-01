package com.yedam.app.di.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Lombok 사용
@Component
//@Setter
@Getter
@ToString
@EqualsAndHashCode
//@NoArgsConstructor
@RequiredArgsConstructor // 필드 중에서 final로 구성된 필드만 따로 가지고 와서 생성자를 만듦.
//@AllArgsConstructor //필드로 선언된 것을 전부 생성자로 만들 때(위험하므로 사용하지 말라고?함)
public class AppleTV {
	@Setter(onMethod_ = { @Autowired }) // setter 주입 방식
	// lombok을 사용해서 setter를 사용하는 경우 setter를 사용한다는 걸? 알려줘야? 함?
	// 모르겠음 둘 중 하나는 DI 얘기임

	// @Autowired 사용 X. 생성자가 하나이기 때문.
	// 단, 생성자가 두 개일 때에는 무조건 Autowired를 집어넣어야 함.

	private MarshallSpeaker speaker;
	// final은 자신을 매개변수로 받는 생성자가 필요.

	public void powerOn() {
		System.out.println("스피커 온");
	}

	public void powerOff() {
		System.out.println("스피커 오프");
	}
}//
