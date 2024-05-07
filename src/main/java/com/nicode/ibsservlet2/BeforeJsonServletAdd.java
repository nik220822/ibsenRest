package com.nicode.ibsservlet2;

import com.nicode.ibsservlet2.logic.Model;
import com.nicode.ibsservlet2.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/add2")
public class BeforeJsonServletAdd extends HttpServlet {
    Model model = Model.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Integer salary = Integer.parseInt(request.getParameter("salary"));

        User user = new User(name, surname, salary);

        model.add(user, Model.counterPlus());
        writer.print("<html>" + "<h3> User " + name + " " + surname + " with salary " + salary + " created sucsessfully </h3>" +
                "<a href=\"addUser.html\">Create a new user</a><br/>" +
                "<a href=\"index.jsp\">Home</a>" + "</html");

    }
}
