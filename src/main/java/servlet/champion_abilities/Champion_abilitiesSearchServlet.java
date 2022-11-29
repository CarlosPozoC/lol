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

@WebServlet(name="Champion_abilitiesSearchServlet", value="/Champion_abilitiesSearch")
public class Champion_abilitiesSearchServlet extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Champion_abilitiesRepository repository = new Champion_abilitiesRepository();
		Integer rango_1 =Integer.parseInt(req.getParameter("rango_1"));
		Integer rango_2 =Integer.parseInt(req.getParameter("rango_2"));
		List<Champion_abilities> champion_abilitiesSearchList = repository.findByRango(rango_1,rango_2);
		req.setAttribute("Champion_abilitiesSearchList", champion_abilitiesSearchList);
		redirect(req, resp, "/Champion_abilities/Champion_abilitiesSearchList.jsp");
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Integer rango_1 =Integer.parseInt(req.getParameter("rango_1"));
		Integer rango_2 =Integer.parseInt(req.getParameter("rango_2"));
		req.setAttribute("rango_1", rango_1);
		req.setAttribute("rango_2", rango_2);
		redirect(req, resp, "/Champion_abilities/Champion_abilitiesSearchList.jsp");
	}
}
