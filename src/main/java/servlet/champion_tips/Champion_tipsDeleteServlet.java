package servlet.champion_tips;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Champion_tips;
import repositories.Champion_tipsRepository;
import servlet.BaseServlet;

@WebServlet(name="Champion_tipsDeleteServlet", value="/Champion_tipsDelete")
public class Champion_tipsDeleteServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doYourOtherThing(req,resp);
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Champion_tipsRepository repository = new Champion_tipsRepository();
		Integer id = Integer.parseInt(req.getParameter("id"));
		repository.deleteById(id);
		redirect(req, resp, "/Champion_tips/Champion_tipsList.jsp");
	}

	private void doYourOtherThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Integer id = Integer.parseInt(req.getParameter("id"));
		String tip = req.getParameter("tip");
		req.setAttribute("id", id);
		req.setAttribute("tip", tip);
		redirect(req, resp, "/Champion_tips/Champion_tipsDelete.jsp");
	}
}
