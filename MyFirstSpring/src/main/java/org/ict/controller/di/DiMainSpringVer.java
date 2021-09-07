package org.ict.controller.di;

import org.ict.controller.di.classfile.Broadcast;
import org.ict.controller.di.classfile.Singer;
import org.ict.controller.di.classfile.Stage;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DiMainSpringVer {
    public static void main(String[] args) {
        // 빈 컨테이너에 호출해 완성품 객체를 받아와 실행하는 코드를 작성해봅니다.
        // 호출시 사용하는 연락용 객체는 GenericXmlApplicationContext입니다.

        GenericXmlApplicationContext context = new GenericXmlApplicationContext(
                "file:src/main/webapp/WEB-INF/spring/root-context.xml");

        // 위에 root-context.xml이라는 bean-container와 연락을 하곘다고 지정했으니
        // 이제 그 공장 객체를 마음껏 꺼내쓸수 있습니다.
        // 얻어노는 방법은 위에 생성한 context객체를 이용해
        // context.getBean("bean이름", 자료형.class); 입니다
        Singer singer = context.getBean("Singer", Singer.class);
        singer.sing();
        
        Stage stage = context.getBean("Stage", Stage.class);
        stage.perform();
        
        Broadcast broad = context.getBean("Broadcast",Broadcast.class);
        broad.onair();

        // 호출 후 context를 닫아야한다
        
        context.close();
    }
}