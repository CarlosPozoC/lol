package servlet.items;

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
import models.Items;
import repositories.ItemsRepository;
import servlet.BaseServlet;

@WebServlet(name="ItemInsertServlet", value="/ItemInsert")
public class ItemInsertServlet extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//doNothing()
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ItemsRepository repository = new ItemsRepository();
		Integer id=Integer.parseInt(req.getParameter("id"));
		String item_name = req.getParameter("item_name");
		String effect = req.getParameter("effect");

		Items i = new Items();
		i.setId(id);
		i.setItem_name(item_name);
		i.setEffect(effect);
		repository.insertOne(i);
		redirect(req, resp, "/Items/ItemInsert.jsp");
	}
}