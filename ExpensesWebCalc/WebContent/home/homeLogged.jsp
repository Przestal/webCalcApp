<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.przestal.helper.VerifyUserLoginStatus"%>
<html>
<head>
  <title>Home</title>
</head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<body>

<% 
VerifyUserLoginStatus vuls = new VerifyUserLoginStatus();
vuls.verifyLoginStatus(session,response);
vuls.addCacheControl(response);
%>
<%@include file="../header/header.jsp"%>
<%@include file="../nav/navLogged.jsp"%>

  <section>
    <img src="/images/calculator.jpg" style="height: 100%;width: 100%">
    <%--<img src="images/homeCalc.jpg" style="width:100%">
    <img src="images/logo.jpg" style="width:100%">
--%></section>
  <section class="w3-container w3-center" style="max-width:600px">
    <h2 class="w3-wide">Home expenses calculator</h2>
    <p class="w3-opacity"><i>We know what is costs</i></p>
    <p class="w3-justify"><i>       Page created for help people managed their bills</i></p>
  </section>
<%@include file="../footer/footer.jsp"%>
</nav>
</body>
</html>
