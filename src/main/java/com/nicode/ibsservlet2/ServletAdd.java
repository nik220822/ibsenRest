package com.nicode.ibsservlet2;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.nicode.ibsservlet2.logic.Model;
import com.nicode.ibsservlet2.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/add")
public class ServletAdd extends HttpServlet {
    Model model = Model.getInstance();
    Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer buffer = new StringBuffer();
        String line;
        PrintWriter writer = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        JsonObject object = gson.fromJson(String.valueOf(buffer), JsonObject.class);

        String name = object.get("name").getAsString();
        String surname = object.get("surname").getAsString();
        int salary = object.get("salary").getAsInt();

        User user = new User(name, surname, salary);
        model.add(user, Model.counterPlus());

        writer.print(gson.toJson(model.getFromList()));
    }
}
