package com.example.demorequest;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "nameServlet", value = "/name-servlet")
public class NameServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");

        StringBuilder error = new StringBuilder();
        if(firstName == null){
            error.append("A first name was not provided.");
        }else if (lastName == null){
            error.append("A last name was not provided.");
        }else if (age == null){
            error.append("A age was not provided.");
        }
        if(error.length() > 0){
            request.setAttribute("error", error.toString());
        }else{
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
        }

        getServletContext().getRequestDispatcher("/name.jsp").forward(request, response);
    }
}
