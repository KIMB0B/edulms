<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
<div class="login-form">
    <form action="<c:url value="/login" />" method="post">
        <div class="form-control">
            <label for="username">사용자 이름</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-control">
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" required>
        </div>
        <c:if test="${not empty errorMsg}">
            <div class="error-message"><h3> ${errorMsg} </h3></div>
        </c:if>
        <c:if test="${not empty logoutMsg}">
            <div class="logout-message"><h3> ${logoutMsg} </h3></div>
        </c:if>

        <div class="form-control">
            <input type="submit" value="로그인">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>

<button type="button" onclick="history.back()" class="back-button">이전으로</button>

</body>
</html>

