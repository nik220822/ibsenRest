package com.nicode.ibsservlet2;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.nicode.ibsservlet2.logic.Model;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/delete")
public class ServletDelete extends HttpServlet {
    Model model = Model.getInstance();
    Gson gson = new Gson();

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer buffer = new StringBuffer();
        String line;
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        JsonObject object = gson.fromJson(String.valueOf(buffer), JsonObject.class);
        int id = object.get("id").getAsInt();
        if (model.getFromList().containsKey(id)) {
            model.getFromList().remove(id);
            writer.print(gson.toJson(model.getFromList()));
        } else writer.print("Пользователя с таким id нет");
    }
}
