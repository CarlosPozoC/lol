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
import servlet.BaseServlet;

@WebServlet(name="championInsertServlet", value="/ChampionInsert")
public class ChampionInsertServlet extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//doNothing()
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ChampionsRepository repository = new ChampionsRepository();

		String champion_name = req.getParameter("champion_name");
		String title = req.getParameter("title");
		String lore= req.getParameter("lore");
		String tags = req.getParameter("tags");

		Champions c = new Champions();
		c.setChampion_name("champion_name");
        c.setTitle("title");
        c.setLore("lore");
        c.setTags("tags");
		
		repository.insertOne(c);
		redirect(req, resp, "/Champions/ChampionInsert.jsp");
	}
}
