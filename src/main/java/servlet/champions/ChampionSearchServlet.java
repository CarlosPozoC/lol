package servlet.champions;

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
import models.Champions;
import repositories.ChampionsRepository;
import models.Champion_tips;
import repositories.Champion_tipsRepository;
import models.Champion_stats;
import repositories.Champion_statsRepository;
import servlet.BaseServlet;

@WebServlet(name="ChampionSearchServlet", value="/ChampionSearch")
public class ChampionSearchServlet extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ChampionsRepository repository_1 = new ChampionsRepository();
		Champion_tipsRepository repository_2 = new Champion_tipsRepository();
		Champion_statsRepository repository_3 = new Champion_statsRepository();
		String stat_name =req.getParameter("stat_name");
		String condition =req.getParameter("condition");
		Integer stat_value =Integer.parseInt(req.getParameter("stat_value"));
		req.setAttribute("stat_name", stat_name);
		req.setAttribute("condition", condition);
		req.setAttribute("stat_value", stat_value);
		List<Integer> champion_ids= repository_3.findByStat(stat_name,condition,stat_value);
		List<Champions> champions= repository_1.findByIds(champion_ids);
		List<Champion_tips> champion_tips= repository_2.findByIds(champion_ids);
		req.setAttribute("champions", champions);
		req.setAttribute("champion_tips", champion_tips);
		redirect(req, resp, "/Champions/ChampionSearchList.jsp");
	}
}
