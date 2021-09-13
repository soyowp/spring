package org.ict.domain;

import lombok.Data;

//lombok을 이용하면 자동으로 getter, setter, toString을 만들 수 있따
//@Data  어노테이션을 클래스 위에 붙이면 자동 생성되며
//확인은 좌측 package Explorer에서 할 수 있다.

@Data
public class TestVO {

	private String name;
	private int age;
	private int num;
	
	
}
