package servlet.champion_stats;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Champion_stats;
import repositories.Champion_statsRepository;
import servlet.BaseServlet;

@WebServlet(name="Champion_statsInsertServlet", value="/Champion_statsInsert")
public class Champion_statsInsertServlet extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//doNothing()
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Champion_statsRepository repository = new Champion_statsRepository();
		Integer champion=Integer.parseInt(req.getParameter("champion"));
		String stat_name = req.getParameter("stat_name");
		Integer stat_value = Integer.parseInt(req.getParameter("stat_value"));
		Integer modifier_per_level = Integer.parseInt(req.getParameter("modifier_per_level"));

		Champion_stats cs = new Champion_stats();
		cs.setChampion(champion);
		cs.setStat_name(stat_name);
		cs.setStat_value(stat_value);
        cs.setModifier_per_level(modifier_per_level);
		repository.insertOne(cs);
		redirect(req, resp, "/Champion_stats/Champion_statsInsert.jsp");
	}
}
