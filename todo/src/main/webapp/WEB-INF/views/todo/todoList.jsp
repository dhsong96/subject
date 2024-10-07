<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/todo.css">
</head>
<body>
	 <div>
        <table class="table">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>완료?</th>
                    <th>TODO subject</th>
                    <th>기한</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody class="tbody">
            <c:forEach items="${todoListVO.todoList}" var="todo">
            	<tr>
                    <td>${todo.id}</td>
                    <c:choose>
                    	<c:when test="${todo.isComplete == 1}">
                    		<td>DONE</td>
                    	</c:when>
                    	<c:otherwise>
                    		<td></td>
                    	</c:otherwise>
                    </c:choose>
                    <td>${todo.subject}</td>
                    <td>${todo.deadline}</td>
                    <c:choose>
                    	<c:when test="${todo.isComplete == 0}">
                    		<td><a href="/todo/success/${todo.id}">완료</a></td>
                    	</c:when>
                    	<c:otherwise>
                    		<td></td>
                    	</c:otherwise>
                    </c:choose>
                    <td><a href="/todo/delete/${todo.id}">삭제</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="button">
            <a href="/todo/create">새 게시글 추가</a>
        </div>
    </div>
</body>
</html>