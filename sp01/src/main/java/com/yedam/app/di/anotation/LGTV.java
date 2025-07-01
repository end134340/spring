package com.yedam.app.di.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 어노테이션이 기본적으로 거의 전부 붙기 때문에 어떤 어노테이션이 필요한지 생각하고 작업.
public class LGTV {

	private MarshallSpeaker speaker;

	// 1) 생성자 주입
//	@Autowired // 생성자가 하나뿐이면 Autowired를 생략해도 spring이 알아서 동작 (component가 붙은 클래스인 경우 생성자가 하나뿐이면 그것만 땡겨와서 쓰면 되기 때문에.)
	public LGTV(MarshallSpeaker speaker) {
		this.speaker = speaker;
	}

	// 2) setter 주입
	public LGTV() {
	};

	@Autowired //setter 주입 방식을 사용하고 싶다면 setter 위에 Autowired 붙임. 
	public void setSpeaker(MarshallSpeaker speaker) {
		this.speaker = speaker;
	}

	public void powerOn() {
		speaker.on();
	}

	public void powerOff() {
		speaker.off();
	}

}
