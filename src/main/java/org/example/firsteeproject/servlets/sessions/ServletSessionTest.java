package org.example.firsteeproject.servlets.sessions;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servletSessionTest", value = "/servlet-session-test")
public class ServletSessionTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // создаем сессию под каждый GET запрос клиента чтобы иметь возможность отслеживать его активность
        HttpSession session = req.getSession();
        Integer sessionNumber = (Integer) session.getAttribute("number");

        if (sessionNumber == null) {
            sessionNumber = 1;
        } else {
           sessionNumber++;
        }

        session.setAttribute("number", sessionNumber);

        PrintWriter pw = resp.getWriter();

        pw.println("<html>");
        pw.println("<h1> Ваша сессия № " + sessionNumber +  "</h1");
        pw.println("</html>");
    }
}
