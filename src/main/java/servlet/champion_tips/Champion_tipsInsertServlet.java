package servlet.champion_tips;

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
import models.Champion_tips;
import repositories.Champion_tipsRepository;
import servlet.BaseServlet;

@WebServlet(name="Champion_tipsInsertServlet", value="/Champion_tipsInsert")
public class Champion_tipsInsertServlet extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//doNothing()
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Champion_tipsRepository repository = new Champion_tipsRepository();
		Integer id=Integer.parseInt(req.getParameter("id"));
		Integer champion=Integer.parseInt(req.getParameter("champion"));
		String tip = req.getParameter("tip");

		Champion_tips ct = new Champion_tips();
		ct.setId(id);
		ct.setChampion(champion);
		ct.setTip(tip);
		repository.insertOne(ct);
		redirect(req, resp, "/Champion_tips/Champion_tipsInsert.jsp");
	}
}

