
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.przestal.helper.*" %>
<html>
<head>
    <title>Contact</title>
</head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<body>
<% VerifyUserLoginStatus vuls = new VerifyUserLoginStatus();
vuls.verifyLoginStatus(session,response);
vuls.addCacheControl(response);
 %>
	<jsp:include page="header/header.jsp"></jsp:include>
    <jsp:include page="nav/navLogged.jsp"></jsp:include>
    <section>
        <img src="images/calculator.jpg" style="height: 100%;width: 100%">
        <%--<img src="images/homeCalc.jpg" style="width:100%">
        <img src="images/logo.jpg" style="width:100%">--%>
    </section>
    <%@ include file="footer/footer.jsp"%>
</body>
</html>
