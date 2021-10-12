<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>all</h1>

<sec:authorize access="isAnonymous()">
<a href="/customLogin">로그인</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<a href="/customLogout">로그아웃</a>
<sec:authentication property="principal" var="info"/> 
${info.member.userName} 님 환영합니다.
<c:if test="${info.member.userName eq '운영자24'}">
너무 반갑습니다
</c:if>
</sec:authorize>
</body>
</html>