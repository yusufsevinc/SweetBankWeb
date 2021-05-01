package DAO.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ConnectionDAO;

@WebServlet("/paraCekme")
public class ParaCekme  extends ConnectionDAO implements IInfoControl{
	RequestDispatcher dispatcher;
	
	private boolean paraCek(int miktar) {
		
		if(miktar <= getaAccountInfo().getBakiye()) {
			String sql = "update kullanici_bakiye set bakiye = bakiye - '" + miktar + "'"
					+ "where kullaniciId =  '"+getaAccountInfo().getKullaniciId()+"'";
			
			try {
				super.statement = super.connection.createStatement();
				int row = super.statement.executeUpdate(sql);
				
					return true;
					
				
			} catch (SQLException e) {
				System.out.println("Hata:   " + e);
			}
		}
		
		return false;
		
		
		
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Para Çekme Do GET metodu çalýþtý");
		
		if (informationValidity()) {
			req.setAttribute("bakiye", getaAccountInfo().getBakiye());
			req.setAttribute("isim", getaAccountInfo().getAdSoyad());
			 dispatcher = req.getRequestDispatcher("paraCekme.jsp");
			dispatcher.forward(req, resp);
			
		}
		else {
			 dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Para çekme Do Post metodu çalýþtý.");
		int miktar = Integer.parseInt(req.getParameter("miktar"));
		
	  
		if (paraCek(miktar)) {
			
			getaAccountInfo().setBakiye(getaAccountInfo().getBakiye()-miktar);
			
			resp.sendRedirect("mainMenu");
		}
		
		
	}
	
	
	
	

	@Override
	public boolean informationValidity() {
		if ((getaAccountInfo().getMusteriNo() != null ) && 
				(getaAccountInfo().getTcNo() != null)) {
			return true;
		}
		return false;
	}

	@Override
	public AccountInfo getaAccountInfo() {
		// TODO Auto-generated method stub
		return AccountInfo.getInstance();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
