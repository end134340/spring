package com.yedam.app.ioc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentMain {
	public static void main(String[] args) {
		// GenericXmlApplicationContext => xml파일을 읽어들여 컨테이너를 만들어주는 클래스.
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		// src/main/resources(물리적 경로) => classpath(논리적 경로)로 매핑하여 찾아올 수 있어 저 파일 밑에 있는 건 classpath로 할수있음
		
		//Student라는 클래스를 가진 빈을 달라고 함
		Student kang = ctx.getBean(Student.class); //scope: 변수가 선언되고 유지될 수 있는 유효 범위
		// .class => class 파일에 관한 정보를 전부 가진 클래스를 따로 불러냄
		System.out.println(kang);
		
		ctx.close();

	}

}//
