package org.example.firsteeproject.servlets.redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "firstServlet", value = "/redirect-to-webSite")
public class ServletRedirectToWebSite extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // пример редиректа пользователя на страницу Яндекс Дзен
        // при совершении GET запроса (.../first-servlet) в нашем сервлете FirstServlet
        resp.sendRedirect("https://dzen.ru/?yredirect=true");
    }
}
