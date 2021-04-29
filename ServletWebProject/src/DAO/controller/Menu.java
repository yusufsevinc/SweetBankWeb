package DAO.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.security.auth.Refreshable;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ConnectionDAO;
import DAO.Data;
@WebServlet("/mainMenu")
public class Menu extends Data implements IInfoControl {
	
	private String musteriNo;
	private String musteriSifre;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("menu doGet metodu çaðýrýldý...");

		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" menu do POST ÇALIÞTI");

		HttpSession session = req.getSession();
		 musteriNo = (String)session.getAttribute("musteriNo");
		 musteriSifre = (String)session.getAttribute("musteriSifre");
		 

        if (musteriNo == null || musteriSifre == null){
        	RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
			
		}else {
			
			req.setAttribute("kullaniciId", getaAccountInfo().getAdSoyad());
			req.setAttribute("bakiye", getaAccountInfo().getBakiye());
		
			RequestDispatcher dispatcher = req.getRequestDispatcher("menu.jsp");
			dispatcher.forward(req, resp);
			
			
			
			
			
		
		}
	}


	@Override
	public boolean informationValidity() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public AccountInfo getaAccountInfo() {
		// TODO Auto-generated method stub
		return AccountInfo.getInstance();
	}



}
