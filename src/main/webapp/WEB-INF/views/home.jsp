<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학사 정보 시스템</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
</head>
<body>

<div class="header">
    <h1>학사 정보 시스템</h1>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div class="user-info">
            <div class="username">${pageContext.request.userPrincipal.name}님 안녕하세요!</div>
            <a href="javascript:document.getElementById('logout').submit()" class="login-button">Logout</a>
        </div>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <div class="user-info">
            <a href="<c:url value='/login'/>" class="login-button">login</a>
        </div>
    </c:if>
    <form id="logout" action="<c:url value="/logout" />" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>

<div class="main-content">
    <div class="card">
        <h2>학년별 이수 학점 조회</h2>
        <p>학점 조회를 통해 지금까지 이수한 과목들을 확인하세요.
            각 학년, 학기별로 세부 사항을 검토할 수 있습니다.</p>
        <a href="<c:url value='/completion/courses'/>" class="submit-button">submit</a>
    </div>
    <div class="card">
        <h2>수강 신청하기</h2>
        <p>다가오는 학기의 수강 신청을 시작하세요.
            원하는 교과목을 선택하고, 필요한 정보를 입력한 후 신청하세요.</p>
        <a href="<c:url value='/registration'/>" class="submit-button">submit</a>
    </div>
    <div class="card">
        <h2>수강 신청 조회</h2>
        <p>수강 신청한 교과목 목록을 확인할 수 있습니다.
            신청 내역을 검토하고 필요한 경우 변경하세요.</p>
        <a href="<c:url value='/registration/courses'/>" class="submit-button">submit</a>
    </div>
</div>

</body>
</html>
