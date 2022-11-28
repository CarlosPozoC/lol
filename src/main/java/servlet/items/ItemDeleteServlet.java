package servlet.items;

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
import models.Items;
import repositories.ItemsRepository;
import servlet.BaseServlet;

@WebServlet(name="ItemsDeleteServlet", value="/ItemDelete")
public class ItemDeleteServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doYourOtherThing(req,resp);
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ItemsRepository repository = new ItemsRepository();
		Integer id = Integer.parseInt(req.getParameter("id"));
		repository.deleteById(id);
		redirect(req, resp, "/Items/ItemList.jsp");
	}

	private void doYourOtherThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Integer id = Integer.parseInt(req.getParameter("id"));
		String item_name = req.getParameter("item_name");
		req.setAttribute("id", id);
		req.setAttribute("item_name", item_name);
		redirect(req, resp, "/Items/ItemDelete.jsp");
	}
}
