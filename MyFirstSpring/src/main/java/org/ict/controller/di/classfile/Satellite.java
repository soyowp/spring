package org.ict.controller.di.classfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Satellite {

    private Broadcast broadcast;
    
    @Autowired
    public Satellite(Broadcast broadcast) {
        this.broadcast = broadcast;
    }

    public void international(){
        System.out.print("위성으로 전세계 송출되는 ");
        broadcast.onair();
    }
}
