package org.ict.controller.di.classfile;

import org.springframework.stereotype.Component;

@Component
public class Singer {

	public void sing() {
		System.out.print("가수가 노래를 합니다");
	}
}
