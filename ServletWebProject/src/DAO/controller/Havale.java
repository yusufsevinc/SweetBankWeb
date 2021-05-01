package DAO.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ConnectionDAO;

@WebServlet("/havale")
public class Havale  extends ConnectionDAO{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	super.doGet(req, resp);
	RequestDispatcher dispatcher = req.getRequestDispatcher("havale.jsp");
	dispatcher.forward(req, resp);
	}

}
