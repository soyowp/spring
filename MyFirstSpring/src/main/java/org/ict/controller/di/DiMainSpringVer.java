package org.ict.controller.di;


import org.ict.controller.di.classfile.Satellite;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DiMainSpringVer {
    public static void main(String[] args) {
        
        //컴포넌트 스캔 호출용 객체 GenericXmlApplicationContext

        GenericXmlApplicationContext context = new GenericXmlApplicationContext(
                "file:src/main/webapp/WEB-INF/spring/root-context.xml");

        // 위에 root-context.xml이라는 bean-container와 연락을 하겠다고 지정했으니
        // context.getBean("bean이름", 자료형.class);

        Satellite satellite = context.getBean("satellite", Satellite.class);
        satellite.international();

        //context.close(); 해주기
        
        
        context.close();
    }
}