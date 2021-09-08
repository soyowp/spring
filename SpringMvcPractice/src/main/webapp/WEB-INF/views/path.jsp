<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page session="false" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Insert title here</title>
            </head>

            <body>
                <h1>현재 보고계신 페이지는 ${page} 번 페이지 입니다</h1>

                <!--JSTL로 pag가 100 미만이면 h2태그로 초반부 100~200이면 중반부 200이상이면 후반부 추가 출력-->

                <c:if test="${page < 100}">
                    <h2>초반부</h2>
                </c:if>
                <c:if test="${page >= 100 && page < 200}">
                    <h2>중반부</h2>
                </c:if>
                <c:if test="${page >= 200}">
                    <h2>후반부</h2>
                </c:if>

            </body>

            </html>