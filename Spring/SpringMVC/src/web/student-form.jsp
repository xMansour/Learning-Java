<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Form</title>
    <style>
        .error{color: red}
    </style>
</head>
<body>
<%--@elvariable id="student" type="com.mansour.springmvc.models.Student"--%>
<form:form action="/student/processForm" modelAttribute="student" method="post">
    <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <br>
    <br>
    <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br>
    <br>
    <form:input path="age"/>
    <form:errors path="age" cssClass="error"/>
    <br>
    <br>
    <form:input path="courseCode"/>
    <form:errors path="courseCode" cssClass="error"/>
    <br>
    <br>
    <select name="country">
        <option value="egypt">Egypt</option>
        <option value="usa">USA</option>
        <option value="france">France</option>
    </select>
    <br>
    <br><br>
    <br><br>
    <br>
    <input type="submit" value="Submit"/>
    <br>
    <br>


</form:form>
</body>
</html>
