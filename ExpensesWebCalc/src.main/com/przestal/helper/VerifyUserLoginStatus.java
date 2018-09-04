package com.przestal.helper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class VerifyUserLoginStatus extends HttpServlet {


    public void verifyLoginStatus(HttpSession session, HttpServletResponse response) {


        if (session.getAttribute("email") == null) {
            try {
                response.sendRedirect("/login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public void addCacheControl(HttpServletResponse response){
        response.addHeader("cache-control","no-cache, must-revalidate, no-store");

        response.addHeader("pragma","no-cache");
        response.addHeader("expires","0");

    }

}
