package com.example.demo2333;

import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")

public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
       //response.setContentType("text/html");

        System.out.println("POST Hello");

        // Hello
        /* PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

         */

        String userName = request.getParameter("user_name");
        String userLastname = request.getParameter("user_surname");

        ServletContext context =getServletContext();
        context.setAttribute("Name", userName);
        context.setAttribute("LastName", userLastname);

        String userFnameLname = userName + userLastname;

        PrintWriter out = response.getWriter();
        out.println("Adiniz " + userName);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       System.out.println("GET Hello");

       response.getWriter().println("<h1>Hello </h1>");
    }

    public void destroy() {
    }
}