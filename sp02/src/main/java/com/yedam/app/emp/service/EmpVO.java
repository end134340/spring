package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 변경하는 일이 빈번하게 일어나므로 일일이 setter getter를 넣기보다는 lombok의 @Data로 처리
@Builder // => 클래스를 생성할 때 초기값을 세팅해야 하는데, 넘겨주고자 하는 초기값을 세팅해서 builder라는거에 넘겨주면 초기값 세팅해서 반환해줌??? 더 자세한것은 빌더패턴 검색, , ,
@AllArgsConstructor // 빌더 패턴을 사용하기 위해 추가해야 하는 어노테이션.
@NoArgsConstructor 	// @Data는 원래 NoArgsConstructor(기본 생성자)을 생성하는데, @Builder를 사용하면 기본 생성자를 만들어주지 않기 때문에 추가 필요.
public class EmpVO {
	// application.properties의 mybatis.configuration.map-underscore-to-camel-case=true설정 때문에 _를 넣으면 안됨.
	// employee_id => employeeId => setEmployeeId (_를 카멜케이스로 변환해서, 이걸 기반으로 setter를 실행함.)
	private Integer employeeId; 
	// primary key(not null)에 대해서는 객체를 통해 설정. wrap class. . . 화면에서 값이 안 넘어올 때 기본값은 대응할 수 없기 때문에. 참조 타입은 null값을 가질 수 있음.
	private String lastName;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate; // import시 sql.Date가 아니라 util.Date 선택.
	private String jobId;
	private double salary; // salary가 실수값을 가지기 때문에 double
	
} //
