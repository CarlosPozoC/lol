package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {

    protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws ServletException, IOException{
        req.getRequestDispatcher(jsp).forward(req, resp);
    }
}
