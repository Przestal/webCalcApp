package com.przestal.controller;

import com.przestal.bean.RegisterBean;
import com.przestal.dao.RegisterDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("psw-repeat");

        if (password.equals(passwordRepeat)) {
            RegisterBean registerBean = new RegisterBean();
            registerBean.setEmail(email);
            registerBean.setPassword(password);
            registerBean.setPasswordRepeat(passwordRepeat);

            RegisterDao registerDao = new RegisterDao();
            String createUsers = registerDao.createUser(registerBean);

            HttpSession session = req.getSession();
            
            if (createUsers.equals("SUCCESS")) {
            	session.removeAttribute("email");
                session.invalidate();
                
                req.getRequestDispatcher("registrationFiles/registerSuccess.jsp").forward(req, resp);
            } else if (createUsers.equals("FAILED")) {

                req.getRequestDispatcher("registrationFiles/registerFailEmail.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("registrationFiles/registerFailPassword.jsp").forward(req,resp);

        }
    }
}
