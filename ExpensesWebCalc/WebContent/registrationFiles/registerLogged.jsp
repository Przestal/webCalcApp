<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<%@ page import="com.przestal.helper.*" %>
<html>
<style>
    body, html {
        height: 100%;
        font-family: Arial, Helvetica, sans-serif;
    }

    * {
        box-sizing: border-box;
    }

    .bg-img {
        /* The image used */
        background-image: url("/ExpensesWebCalc/images/Expenses.jpg");

        min-height: 100%;

        /* Center and scale the image nicely */
        background-position: center;
        background-repeat: no-repeat;
        background-size: 100% 100%;
    }

    /* Add styles to the form container */
    .container {
        position: absolute;
        right: 35%;
        top: 7%;
        margin: 20px;
        max-width: 300px;
        padding: 16px;
        background-color: white;
    }

    /* Full-width input fields */
    input[type=text], input[type=password] {
        width: 100%;
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

    /* Set a style for all buttons */
    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }

    button:hover {
        opacity: 1;
    }

    /* Extra styles for the cancel button */
    .cancelbtn {
        padding: 14px 20px;
        background-color: #f44336;
    }

    /* Float cancel and signup buttons and add an equal width */
    .cancelbtn, .signupbtn {
        float: left;
        width: 50%;
    }

    /* Add padding to container elements */
    .container {
        padding: 16px;
    }

    /* Clear floats */
    .clearfix::after {
        content: "";
        clear: both;
        display: table;
    }

    /* Change styles for cancel button and signup button on extra small screens */
    @media screen and (max-width: 300px) {
        .cancelbtn, .signupbtn {
            width: 100%;
        }
    }


</style>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">

<body>
<% VerifyUserLoginStatus vuls = new VerifyUserLoginStatus();
vuls.verifyLoginStatus(session,response);
vuls.addCacheControl(response);
 %>


<%@include file="/header/header.jsp" %>
<%@include file="/nav/navLogged.jsp" %>
<form action="/registerUser" method="post">
    <div class="bg-img">
        <div class="container">
            <font color="black"><h1>Sign up</h1></font>

            <label><font color="black"><b>Email</b></font></label>
            <input type="text" placeholder="Enter Email" name="email" required>

            <label><font color="black"><b>Password</b></font>
            </label>
            <input type="password" placeholder="Enter Password" name="password" required>

            <label><font color="black"><b>Repeat Password</b></font></label>
            <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
            <label>
                <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px">
                <font color="black"> Remember me</font>
            </label>

            <font color="black"><p>By creating an account you agree to our</font> <a href="#"
                                                                                     style="color:dodgerblue">Terms
            & Privacy</a>.</p>

            <div class="clearfix">
                <button type="button" class="cancelbtn">Cancel</button>
                <button onclick="congratulation" type="submit" class="signupbtn">Sign Up</button>
            </div>
            <p id="cong"></p>

        </div>


    </div>
</form>
<%@include file="/footer/footer.jsp" %>
</body>
</html>
