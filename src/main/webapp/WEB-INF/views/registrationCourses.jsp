<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>수강 신청 조회</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/table.css">
</head>
<body>

<div class="header">
    <h1>수강 신청 조회</h1>
</div>

<div class="main-content">
    <table>
        <thead>
        <tr>
            <th>년도</th>
            <th>학기</th>
            <th>교과목명</th>
            <th>교과구분</th>
            <th>담당교수</th>
            <th>학점</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.year}</td>
                <td>${course.semester}</td>
                <td>${course.name}</td>
                <td>${course.division}</td>
                <td>${course.professor}</td>
                <td>${course.credit}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
