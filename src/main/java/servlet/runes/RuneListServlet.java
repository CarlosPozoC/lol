package servlet.runes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Runes;
import repositories.RunesRepository;
import servlet.BaseServlet;

import java.io.IOException;
import java.util.List;

@WebServlet(name="RuneListServlet", value="/RuneList")
public class RuneListServlet extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//doNothing()
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RunesRepository repository = new RunesRepository();
		List<Runes> RuneList = repository.findAll();
		req.setAttribute("Runes", RuneList);
		redirect(req, resp, "/Runes/RuneList.jsp");
	}
}
