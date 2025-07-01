package com.yedam.app.di;

public class SamsungTV {
	private SonySpeaker speaker;
	// 부품 관계: 클래스 안에 클래스를 또 가지고있음

	public SamsungTV(SonySpeaker speaker) { // 1. 생성자를 통해 아예 처음부터 스피커를 받을 수 있게 처리하는 방법.
		this.speaker = speaker;
	}
	
	public SamsungTV() {
		//필드의 값이 변경되어야 하는 경우는 setter를 사용. 처음 값을 그대로 유지해야 할 때에는 생성자를 많이 사용하는 편.
	}

	public void setSpeaker(SonySpeaker speaker) { // 2. setter를 이용해 값을 입력할 수 있게 하는 방법.
		this.speaker = speaker;
	}

	public void powerOn() {
		speaker.on();
	}

	public void powerOff() {
		speaker.off();
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}

} //
