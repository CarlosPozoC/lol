package servlet.champion_stats;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Champion_stats;
import repositories.Champion_statsRepository;
import servlet.BaseServlet;

import java.io.IOException;
import java.util.List;

@WebServlet(name="Champion_statsListServlet", value="/Champion_statsList")
public class Champion_statsListServlet extends BaseServlet {
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
		List<Champion_stats> champion_statsList = repository.findAll();
		req.setAttribute("Champion_stats", champion_statsList);
		redirect(req, resp, "/Champion_stats/Champion_statsList.jsp");
	}
}
