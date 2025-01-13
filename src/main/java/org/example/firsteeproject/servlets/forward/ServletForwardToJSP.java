package org.example.firsteeproject.servlets.forward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servletForwardToJSP", value = "/forward-to-JSP")
public class ServletForwardToJSP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //пример форварда пользователя на нашу страницу JSP без замены URL
        // при совершении GET запроса (.../forward-to-JSP) в нашем сервлете ServletForwardToJSP
        RequestDispatcher dispatcher = req.getRequestDispatcher("/testForwardJSP.jsp");
        dispatcher.forward(req, resp);
    }
}
