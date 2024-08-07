<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>수강 신청하기</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/input.css">
</head>
<body>

<div class="header">
    <h1>수강 신청하기</h1>
</div>

<div class="main-content">
    <form action="<c:url value='/registration'/>" method="post">
        <div>
            <label for="year">수강년도</label>
            <input type="text" id="year" name="year" value="2024" readonly>
        </div>
        <div>
            <label for="semester">학기</label>
            <input type="text" id="semester" name="semester" value="2" readonly>
        </div>
        <div>
            <label for="code">교과코드</label>
            <input type="text" id="code" name="code" required>
        </div>
        <div>
            <label for="name">교과목명</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div>
            <label for="division">교과구분</label>
            <input type="text" id="division" name="division" required>
        </div>
        <div>
            <label for="professor">담당교수</label>
            <input type="text" id="professor" name="professor" required>
        </div>
        <div>
            <label for="credit">학점</label>
            <input type="number" id="credit" name="credit" required>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="submit-button">확인</button>
    </form>
</div>

</body>
</html>
