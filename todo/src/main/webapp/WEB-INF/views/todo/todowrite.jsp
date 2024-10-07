<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/todo.css" />
</head>
<body>
<form method="post">
        <div class="grid">
            <div class="subject">
                <label>
                    <h4>제목</h4>
                </label>
            </div>
            <div>
                <label for="subject"></label>
                <input id="subject" type="text" name="subject" value="${writeTodoVO.subject}">
            </div>
            <div>
                <h4>기한</h4>
            </div>
            <div>
                <label for="deadline"></label>
                <input id="deadline" type="date" name="deadline" value="${writeTodoVO.deadline}">
            </div>

        </div>
        <div class="insert">
            <input type="submit" value="저장"/>
        </div>
    </form>
</body>
</html>