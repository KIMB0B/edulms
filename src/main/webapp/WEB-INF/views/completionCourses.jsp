<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학년별 이수 학점 조회</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/table.css">
</head>
<body>

<div class="header">
    <h1>학년별 이수 학점 조회</h1>
</div>

<div class="main-content">
    <table>
        <thead>
        <tr>
            <th>년도</th>
            <th>학기</th>
            <th>취득 학점</th>
            <th>상세보기</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="summary" items="${summaries}">
            <tr>
                <td>${summary.year}</td>
                <td>${summary.semester}</td>
                <td>${summary.totalCredits}</td>
                <td><a href="/completion/courses/detail?year=${summary.year}&semester=${summary.semester}">링크</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
