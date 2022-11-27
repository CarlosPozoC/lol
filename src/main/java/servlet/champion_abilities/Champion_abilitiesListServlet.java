package servlet.champion_abilities;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Champion_abilities;
import repositories.Champion_abilitiesRepository;
import servlet.BaseServlet;

import java.io.IOException;
import java.util.List;

@WebServlet(name="Champion_abilitiesListServlet", value="/Champion_abilitiesList")
public class Champion_abilitiesListServlet extends BaseServlet {
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
		List<Champion_abilities> champion_abilitiesList = repository.findAll();
		req.setAttribute("Champion_abilities", champion_abilitiesList);
		redirect(req, resp, "/Champion_abilities/Champion_abilitiesList.jsp");
	}
}

