package org.example.firsteeproject.servlets.redirect;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servletRedirectToJSP", value = "/redirect-to-JSP")
public class ServletRedirectToJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //пример редиректа пользователя на нашу страницу JSP
        // при совершении GET запроса (.../redirect-to-JSP) в нашем сервлете ServletRedirectToJSP
        resp.sendRedirect("/testRedirectJSP.jsp");
    }
}
