package servlet.champions;

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
import models.Champions;
import repositories.ChampionsRepository;
import servlet.BaseServlet;

@WebServlet(name="ChampionUpdateServlet", value="/ChampionUpdate")
public class ChampionUpdateServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doYourOtherThing(req, resp);
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ChampionsRepository repository = new ChampionsRepository();
		Integer id = Integer.parseInt(req.getParameter("id"));
		redirect(req, resp, "/Champions/ChampionUpdate.jsp");
	}

	private void doYourOtherThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Integer id = Integer.parseInt(req.getParameter("id"));
		req.setAttribute("id", id);
		redirect(req, resp, "/Champions/ChampionUpdate.jsp");
	}
}