package com.nicode.ibsservlet2;

import com.nicode.ibsservlet2.logic.Model;
import com.nicode.ibsservlet2.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(urlPatterns = "/get")
public class ServletList extends HttpServlet {
    Model model = Model.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        if (id == 0) {
            writer.print("<html>" +
                    "<h3>Доступные пользователи:</h3><br/>");
            for (Map.Entry<Integer, User> e : model.getFromList().entrySet()) {
                writer.print(
                        "<li>user ID: " + e.getKey() + "</li>" +
                                "<li>Имя: " + e.getValue().getName() + "</li>" +
                                "<li>Фамилия: " + e.getValue().getSurname() + "</li>" +
                                "<li>Зарплата: " + e.getValue().getSalary() + "</li>" +
                                "</ul>" +
                                "<br/>");
            }
            writer.print("</<ul>" +
                    "<a href=\"index.jsp\">Домой</a>" +
                    "</html>");
        } else if (id > 0) {
            if (!model.getFromList().containsKey(id)) {
                writer.print("<html>" +
                        "<h3>Такой пользователь не был найден</h3>" +
                        "<a href=\"index.jsp\">Домой</a>" +
                        "</html>");
            } else {
                writer.print("<html>" +
                        "<h3>Запрошенный пользователь</h3>" +
                        "Имя: " + model.getFromList().get(id).getName() + "<br/>" +
                        "Фамилия: " + model.getFromList().get(id).getSurname() + "<br/>" +
                        "Зарплата: " + model.getFromList().get(id).getSalary() + "<br/>" + "<br/>" +
                        "<a href=\"index.jsp\">Домой</a>" +
                        "</html>");
            }
        } else {
            writer.print("<html>" +
                    "<h3>ID должен быть положительным</h3>" +
                    "<a href=\"index.jsp\">Домой</a>" +
                    "</html>");
        }
    }
}
