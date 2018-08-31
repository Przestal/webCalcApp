package com.przestal.controller;

import com.przestal.bean.*;
import com.przestal.dao.*;
import com.przestal.helper.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginBean loginBean = new LoginBean();
        loginBean.setEmail(email);
        loginBean.setPassword(password);

        LoginDao loginDao = new LoginDao();
        String userValidate = loginDao.authenticateUser(loginBean);

        HttpSession session = request.getSession();
        SetSumSession sumSession = new SetSumSession();
        sumSession.showSumValueDB(request);
        
        if (userValidate.equals("SUCCESS"))
        {
            session.setAttribute("email", email);
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }else {

            response.sendRedirect("/login.jsp");
            //request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

}
