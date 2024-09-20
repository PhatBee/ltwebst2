<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 20/09/2024
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ltwebst2/register" method="post">

    <c:if test="${alert !=null}">
    <h3 class="alert alert danger">${alert}</h3>
    </c:if>


    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <label for="username"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" id="username" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" id="password" required>

        <label for="email"><b>Email</b></label>
        <input type="email" placeholder="Enter Email" name="email" id="email" required>

        <label for="fullname"><b>Full Name</b></label>
        <input type="fullname" placeholder="Enter Full name" name="fullname" id="fullname" required>

        <label for="phone"><b>Phone number</b></label>
        <input type="phone" placeholder="Enter Phone Number" name="phone" id="phone" required>
        <hr>

        <button type="submit" class="registerbtn">Register</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Sign in</a>.</p>
    </div>

</body>
</html>
