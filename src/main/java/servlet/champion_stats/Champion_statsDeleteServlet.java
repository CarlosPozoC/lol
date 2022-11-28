package servlet.champion_stats;

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
import models.Champion_stats;
import repositories.Champion_statsRepository;
import servlet.BaseServlet;

@WebServlet(name="Champion_statsDeleteServlet", value="/Champion_statsDelete")
public class Champion_statsDeleteServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doYourOtherThing(req,resp);
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Champion_statsRepository repository = new Champion_statsRepository();
		Integer champion = Integer.parseInt(req.getParameter("champion"));
		repository.deleteById(champion);
		redirect(req, resp, "/Champion_stats/Champion_statsList.jsp");
	}

	private void doYourOtherThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Integer champion = Integer.parseInt(req.getParameter("champion"));
		String stat_name = req.getParameter("stat_name");
		req.setAttribute("champion", champion);
		req.setAttribute("stat_name", stat_name);
		redirect(req, resp, "/Champion_stats/Champion_statsDelete.jsp");
	}
}