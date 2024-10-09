<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginpage</title>
<link rel="stylesheet" type="text/css" href="/css/login.css">
</head>
<body>
			<h1>로그인</h1>
            <form:form modelAttribute="loginMemberVO" method="post">
            <c:if test="${not empty message}">
              <div class="errors">${message}</div>
             </c:if>
                <div class="grid">
                    <label for="email">이메일</label>
                    <input id="email" type="text" name="email" value="${loginMemberVO.email}" />
					<form:errors path="email" element="div" cssClass="error" />
					
                    <label for="password">비밀번호</label>
                    <input id="password" type="password" name="password" >
                    <form:errors path="password" element="div" cssClass="error" />
                </div>
                <input type="submit" value ="로그인"/>
            </form:form>
</body>
</html>