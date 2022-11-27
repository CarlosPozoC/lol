package servlet.champion_tips;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Champion_tips;
import repositories.Champion_tipsRepository;
import servlet.BaseServlet;

import java.io.IOException;
import java.util.List;

@WebServlet(name="Champion_tipsListServlet", value="/Champion_tipsList")
public class Champion_tipsListServlet extends BaseServlet {
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
		List<Champion_tips> champion_tipsList = repository.findAll();
		req.setAttribute("Champion_tips", champion_tipsList);
		redirect(req, resp, "/Champion_tips/Champion_tipsList.jsp");
	}
}
