package servlet.champion_abilities;

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
import models.Champion_abilities;
import repositories.Champion_abilitiesRepository;
import servlet.BaseServlet;

@WebServlet(name="Champion_abilitiesInsertServlet", value="/Champion_abilitiesInsert")
public class Champion_abilitiesInsertServlet extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//doNothing()
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Champion_abilitiesRepository repository = new Champion_abilitiesRepository();
		Integer id=Integer.parseInt(req.getParameter("id"));
		Integer champion=Integer.parseInt(req.getParameter("champion"));
		String champion_name = req.getParameter("champion_name");
		String champion_description = req.getParameter("champion_description");
		String effect = req.getParameter("effect");
		String cost= req.getParameter("cost");
		Integer rango =Integer.parseInt(req.getParameter("rango"));

		Champion_abilities ca = new Champion_abilities();
		ca.setId(id);
		ca.setChampion(champion);
		ca.setChampion_name(champion_name);
		ca.setChampion_description(champion_description);
        ca.setEffect(effect);
        ca.setCost(cost);
        ca.setRango(rango);
		repository.insertOne(ca);
		redirect(req, resp, "/Champion_abilities/Champion_abilitiesInsert.jsp");
	}
}
