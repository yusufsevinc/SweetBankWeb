package DAO.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import DAO.ConnectionDAO;
import DAO.Data;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





@WebServlet("/loginController")
public class Login extends ConnectionDAO implements IInfoControl {
	
	
	
	String musteriNo ;
	String musteriSifre;
	
	private boolean kontrol(String kullaniciId , String sifre) {
	
		   String sql = "SELECT tcNo , musteriNo,sifre from kullanicilar "
	                + "where (tcNo = '" + kullaniciId + "'"
	                + " OR "
	                + "musteriNo = '" + kullaniciId + "')"
	                + "AND"
	                + " sifre = '" + sifre + "'";
	        try {
	            super.statement = super.connection.createStatement();
	            ResultSet rs = statement.executeQuery(sql);
	            while (rs.next()) {
	            	
	                return true;
	            }

	        } catch (SQLException ex) {
	        	System.out.println("Hata:  " +ex);

	        }
	        return false;
	     
	}
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
		
		
		System.out.println("Login doGet çalýþtý");


	}//doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		musteriNo = req.getParameter("username");
		musteriSifre = req.getParameter("password");
		if (kontrol(musteriNo, musteriSifre)) {
			HttpSession session = req.getSession();
			session.setAttribute("musteriNo", musteriNo);
			session.setAttribute("musteriSifre",musteriSifre );
			getaAccountInfo().getInstance().girisYap(musteriNo);
			session.setAttribute("isim", getaAccountInfo().getAdSoyad());
			//session.setAttribute("bakiye", getaAccountInfo().getBakiye());
			
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("mainMenu");
			dispatcher.forward(req, resp);
			
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
		
		System.out.println("Login doPost çalýþtý");
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
	@Override
	protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}





	
}
