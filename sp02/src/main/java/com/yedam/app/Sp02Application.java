package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // => @SpringBootConfiguration / @EnableAutoConfiguration // Auto-Config @ComponentScan // spring 를 한꺼번에 지정한 어노테이션.
// 설정 정보를 가지고 있다는 클래스라는 정보를 알림.
@MapperScan(basePackages = "com.yedam.app.**.mapper") //mybatis가 mybatis파일을 스스로 읽어들인 다음에 스프링(컨테이너)에 넘겨줌. 그래서 bean 인식?
// "com.yedam.app.**.mapper" => 중간에 **가 들어간 이유는 기능에 따라 mapper가 들어가므로 앞으로 기능이 추가될 경우를 대비하여 진행.
// application.properties에서 사용하는 *는 하나. MapperScan에서 사용하는 *는 두개여야함. 두개가 서로 다른 기능이니까 읽어들이는 방식이 다름. 왜 그런지 고민하지 말라고 하심.
// 범위를 좁히는 이유는 bean이 중복 등록되는 경우를 방지하기 위해서.
public class Sp02Application {

	public static void main(String[] args) {
		SpringApplication.run(Sp02Application.class, args);
	}

}
 