<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>学生所有信息</title>
</head>
<body>

<table border="1">
    <tr>
        <td>姓名</td>
        <td>QQ</td>
        <td>毕业学校</td>
        <td>在线学号</td>
        <td>修真类型</td>
        <td>日报链接</td>
        <td>立愿</td>
        <td>辅导师兄</td>
        <td>从哪里了解修真院</td>
        <td>预计入学时间</td>

    </tr>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.name}</td>
            <td>${student.qq}</td>
            <td>${student.graduateSchool}</td>
            <td>${student.onlineId}</td>
            <td>${student.studyType}</td>
            <td>${student.dailyLink}</td>
            <td>${student.wish}</td>
            <td>${student.coachSenior}</td>
            <td>${student.knowFrom}</td>
            <td>${student.startStudyTime}</td>
            <td><a href="/RestSpring/v2/student">添加</a> </td>
        </tr>
    </c:forEach>
</table>

<a href="/RestSpring/v2/student/page/insert">添加学员</a>


</body>
</html>
