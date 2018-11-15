<%@ page import="com.przestal.dao.*" %>
<%@ page import="com.przestal.bean.*" %>
<%@ page import="com.przestal.helper.VerifyUserLoginStatus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<style>
    html,body {
        height: 100%;
        font-family: Arial, Helvetica, sans-serif;
    }
	
    * {
        box-sizing: border-box;
    }

    .bg-img {
        /* The image used */
        background-image: url("images/homeCalc.jpg");

        min-height: 100%;

        /* Center and scale the image nicely */
        background-position: center center;
        background-repeat: no-repeat;
        background-size: 100% 100%;
    }

    /* Add styles to the form container */
    .container {
        position: absolute;
        right: 35%;
        top: 20%;
        margin: 20px;
        max-width: 300px;
        padding: 16px;
        background-color: white;
    }

    /* Full-width input fields */
    input[type=text], input[type=password] {
        width: 10%;
        padding: 15px;
        margin: 5px 0 22px 0;
        border: none;
        background: #f1f1f1;
    }

    input[type=text]:focus, input[type=password]:focus {
        background-color: #ddd;
        outline: none;
    }

    /* Set a style for the submit button */
    .btn {
        background-color: #4CAF50;
        color: white;
        padding: 16px 20px;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }

    .btn:hover {
        opacity: 1;
    }

    table {
    	width: 100%;
		
    }

    th{
    	background-color: #4CAF50;
   		 color: white;
        min-width: 100px;
    }


</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
<%
    VerifyUserLoginStatus vuls = new VerifyUserLoginStatus();
    vuls.verifyLoginStatus(session,response);
    vuls.addCacheControl(response);
%>

<%@ include file="header/header.jsp" %>
<%@ include file="nav/navLogged.jsp" %>

<div class="w3-col l10 m12" style="overflow: auto"  contenteditable="false">

    <table class="w3-table-all" >
		
        
        <tr class="w3-green">
            <th>Year/Month
            <a href="/addColumn.jsp">
                    <span class="glyphicon glyphicon-plus-sign"></span>
            </a>
            <a href="/addValue.jsp">
                    <span class="glyphicon glyphicon-plus-sign"></span>
            </a>
            </th>
            <jsp:include page="table/tableColumn.jsp"></jsp:include>
        </tr>
        <tr>
            <td>2018/08</td>
             <jsp:include page="table/tableRow.jsp"></jsp:include>
        </tr>
        <tr><td>2018/09</td></tr>
        
        <tr><td>2018/10</td></tr>
		<tr><td>2018/11</td></tr>
		<tr><td>2018/12</td></tr>
		<tr><td>2019/01</td></tr>
		<tr><td>2019/02</td></tr>
		<tr><td>2019/03</td></tr>
		<tr><td>2019/04</td></tr>
		<tr><td>2019/05</td></tr>
		<tr><td>2019/06</td></tr>
		<tr><td>2019/07</td></tr>
		<tr><td>2019/08</td></tr>
		<tr><td>2019/09</td></tr>
		<tr><td>2019/10</td></tr>
		<tr><td>2019/11</td></tr>
        <tr><td>2019/12</td></tr>
    </table>
</div>

<%@ include file="footer/footer.jsp" %>
</body>
</html>

