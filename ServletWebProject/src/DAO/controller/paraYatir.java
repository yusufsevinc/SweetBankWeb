package DAO.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ConnectionDAO;


@WebServlet("/paraYatir")
public class paraYatir  extends ConnectionDAO implements IInfoControl{

	RequestDispatcher dispatcher;
	
	
	private void paraYatir(int miktar) {
		
		String sql = "update kullanici_bakiye set "
				+ "bakiye = bakiye + '" + miktar + "' "
						+ "where kullaniciId = '"+getaAccountInfo().getKullaniciId()+"'";
		
		try {
			super.statement = super.connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Hata: " + e);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("para yatir doGET metodu çalýþtý");
		HttpSession session = req.getSession();
		if(informationValidity()) {
			req.setAttribute("bakiye", getaAccountInfo().getBakiye());
			//req.setAttribute("isim", getaAccountInfo().getAdSoyad());
		
		    
		    dispatcher = req.getRequestDispatcher("paraYatir.jsp");
		    dispatcher.forward(req, resp);
		}
		else {
			dispatcher = req.getRequestDispatcher("login.jsp");
		    dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int miktar = Integer.parseInt(req.getParameter("miktar"));
		
		  
		paraYatir(miktar);
			
			getaAccountInfo().setBakiye(getaAccountInfo().getBakiye()+miktar);
//			dispatcher = req.getRequestDispatcher("mainMenu");
//			dispatcher.forward(req, resp);
			resp.sendRedirect("mainMenu");
			
		 
			
		
		
	}
	
	
	
	@Override
	public boolean informationValidity() {
		if(getaAccountInfo().getMusteriNo() != null) {
			return true;
		}
		return false;
	}

	@Override
	public AccountInfo getaAccountInfo() {
		// TODO Auto-generated method stub
		return AccountInfo.getInstance();
	}

}
