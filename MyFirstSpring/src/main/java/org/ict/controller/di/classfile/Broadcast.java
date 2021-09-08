package org.ict.controller.di.classfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Broadcast {

	private Stage stage;
	
	@Autowired
	public Broadcast(Stage stage) {
		this.stage = stage;
	}
	
	public void onair() {
		System.out.print("방송용 ");
		stage.perform();
		
	}
}
