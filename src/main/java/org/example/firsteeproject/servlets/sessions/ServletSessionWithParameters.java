package org.example.firsteeproject.servlets.sessions;

import org.example.firsteeproject.testClasses.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "servletSessionWithParameters", value = "/servlet-session-with-parameters")
public class ServletSessionWithParameters extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        //заносим объект собственного класса User в сессию по GET запросу
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        //получаем данные из параметров URL нашего GET запроса которые соответвуют переменным класса User
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        if (user == null) user = new User(name, age);

        //заносим наш готовый объект класса User в сессию
        session.setAttribute("user", user);

        //делаем перевод нашего клиента методом форвард на JSP представление с выводом дынных об объекте User на экран
        getServletContext().getRequestDispatcher("/testForwardUser.jsp").forward(req, resp);
    }
}
