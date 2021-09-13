package org.ict.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

//@Log4j는 로깅 기능을 쓴다
//System.out.println();같은 경우는 로깅만이 목적이 아니기때문에
//메모리를 잡아먹는다.
//따라서 로그를 찍을때 System.out.println();을 쓰는건 권장하지 않는다.
//spring은 Log4j spirng-boot는 Log4j2

@Log4j
public class MySQLConnectionTest {
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://127.0.0.1:3306/mysql?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private final String USER = "root";
	private final String PW = "mysql";

	//테스트가 붙은 메서드만 실행한다.
	@Test
	public void testConnection() throws Exception {
		
		Class.forName(DRIVER);

		try (Connection con = DriverManager.getConnection(URL, USER, PW)) {

			log.info(con);
			log.info("정상적으로 연결되었습니다.");

		} catch (Exception e) {
			
			fail(e.getMessage());
		}
	}
	//@Test
	public void testConnection2() {
		log.info("@test가 없으면 실행이 안됩니다");
	}
}
