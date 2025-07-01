package com.yedam.app.di;

public class DefaultMain {
	public static void main(String[] args) {
		// 생성자를 기반으로 해서 스피커를 받는 경우 생성자를 호출할 때부터 스피커를 넣어주어야 함.
		SonySpeaker speaker = new SonySpeaker();
//		SamsungTV tv = new SamsungTV(speaker); //생성자를 사용하는 경우 매개값이 존재하지 않는 경우에는 컴파일 단계에서부터 에러가 남.

		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(speaker); // setter를 사용하는 경우 이 구문이 없더라도 컴파일 단계에서는 에러가 나지 않고 실행시에 nullpointexception이 뜸.
		// setter는 메소드이므로 유연하게 사용할 수 있기 때문에 중간에 값을 바꾸어야 하는 경우 이 방법 사용.
		tv.powerOn();
	}
}
