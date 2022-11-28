package servlet.champion_abilities;

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
import models.Champion_abilities;
import repositories.Champion_abilitiesRepository;
import servlet.BaseServlet;

@WebServlet(name="Champion_abilitiesDeleteServlet", value="/Champion_abilitiesDelete")
public class Champion_abilitiesDeleteServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doYourOtherThing(req,resp);
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Champion_abilitiesRepository repository = new Champion_abilitiesRepository();
		Integer id = Integer.parseInt(req.getParameter("id"));
		repository.deleteById(id);
		redirect(req, resp, "/Champion_abilities/Champion_abilitiesList.jsp");
	}

	private void doYourOtherThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Integer id = Integer.parseInt(req.getParameter("id"));
		String champion_name = req.getParameter("champion_name");
		req.setAttribute("id", id);
		req.setAttribute("champion_name", champion_name);
		redirect(req, resp, "/Champion_abilities/Champion_abilitiesDelete.jsp");
	}
}
