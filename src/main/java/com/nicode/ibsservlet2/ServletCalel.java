package com.nicode.ibsservlet2;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/cal-el")
public class ServletCalel extends HelloServlet {
    Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer buffer = new StringBuffer();
        String line;
        PrintWriter writer = response.getWriter();
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

        Integer a = object.get("a").getAsInt();
        Integer b = object.get("b").getAsInt();
        String math = object.get("math").getAsString();
        float resultFloat;
        switch (math) {
            case "+":
                resultFloat = a + b;
                break;
            case "-":
                resultFloat = a - b;
                break;
            case "*":
                resultFloat = a * b;
                break;
            case ":":
            case "/":
                resultFloat = a / b;
                break;
            default:
                resultFloat = 0;
        }
        writer.print(gson.toJson(new Result(resultFloat)));
    }

    private class Result {
        float result;

        Result(float result) {
            this.result = result;
        }
    }
}
