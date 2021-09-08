package org.ict.controller.di.classfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Stage {

	private Singer singer;

	@Autowired
	public Stage(Singer singer) {
		this.singer = singer;
	}

	public void perform() {
		System.out.print("무대에서 ");
		singer.sing();
	}
}
