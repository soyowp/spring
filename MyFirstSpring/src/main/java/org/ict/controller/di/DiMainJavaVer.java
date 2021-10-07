package org.ict.controller.di;

import org.ict.controller.di.classfile.Broadcast;
import org.ict.controller.di.classfile.Singer;
import org.ict.controller.di.classfile.Stage;

public class DiMainJavaVer {
	public static void main(String[] args) {

		Singer s1 = new Singer();
		Stage st = new Stage(s1);
		Broadcast bc = new Broadcast(st);
		s1.sing();
		st.perform();
		bc.onair();
		
	}
}
