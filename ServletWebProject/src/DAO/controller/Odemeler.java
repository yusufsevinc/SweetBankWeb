package DAO.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ant.ReloadTask;

import DAO.ConnectionDAO;

@WebServlet("/odemeler")
public class Odemeler extends ConnectionDAO implements IInfoControl{
	RequestDispatcher dispatcher;
	private float ftrElektirk ;
	private float ftrSu ;
	private float ftrInternet ;
	private float ftrDogalgaz ;
	private float faturaTutari;
	private String faturaAdi;
	
//	private  boolean bakiyeKontrol(float tutar) {
//		
//		if (getaAccountInfo().getBakiye() >= tutar) {
//			return true;
//		}
//		
//		return false;
//	}
	
	private void faturaOde(String faturaAdi , float faturaTutari){
		
		
		String sql1 = "update kullanici_bakiye set bakiye = bakiye - "+faturaTutari+" "
				+ "where kullaniciId = " + getaAccountInfo().getKullaniciId() + "";
		
	
		String sql2 = "update kullanici_faturalar set "+faturaAdi+" = 0 "
                + "where "
                + "kullaniciId = "+getaAccountInfo().getKullaniciId()+"" ;
		
		try {
			statement = connection.createStatement();
			int row = statement.executeUpdate(sql2);
			
			if (row == 1) {
				statement.executeUpdate(sql1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(informationValidity()) {
			
			req.setAttribute("elektrik", getaAccountInfo().getElektrikFaturasi());
			req.setAttribute("su", getaAccountInfo().getSuFaturasi());
			req.setAttribute("dogalgaz", getaAccountInfo().getDogalgazFaturasi());
			req.setAttribute("internet", getaAccountInfo().getInternetFaturasi());
			req.setAttribute("kullaniciAdi", getaAccountInfo().getAdSoyad());
			req.setAttribute("bakiye", getaAccountInfo().getBakiye());
			
			
			
			
			
			dispatcher = req.getRequestDispatcher("odemeler.jsp");
			dispatcher.forward(req, resp);
			System.out.println("doGet if metodu çalýþýyor...");
		}else {
			dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
			System.out.println("doGet else  metodu çalýþýyor...");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
       	
        
		Map<String, String[]> paraMap = req.getParameterMap();
		for (Entry<String, String[]> paramEntry : paraMap.entrySet()) {
		    
			List<String> deger = 	Arrays.asList(paramEntry.getValue());
		    faturaAdi = paramEntry.getKey();
			faturaTutari = Float.parseFloat(deger.get(0));
		}
       
       		
       			faturaOde(faturaAdi, faturaTutari);
       			getaAccountInfo().faturalarýAl();
       			getaAccountInfo().setBakiye(getaAccountInfo().getBakiye() - faturaTutari);
       		
       			doGet(req, resp);
       			
       			
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
	
	
	

}
