package DAO.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ConnectionDAO;

@WebServlet("/basvuru")
public class Basvuru extends ConnectionDAO implements IInfoControl {

	private String musteriNo;
	private String sifre;
	private String adSoyad;
	private String tcNo;
	private String telNo;
	private String guvenlikSorusu;
	private String guvenlikCevap;
	
	
	private boolean uyeOl(){
		String sql = "insert into kullanicilar (adSoyad,tcNo,telNo,guvenlikSorusu , guvenlikCevap,musteriNo,sifre)"
				+ "values "
				+ "('"+adSoyad.toUpperCase()+"' , '"+tcNo+"' "+" , '"+telNo+"' "+" , '"+guvenlikSorusu+"' "+" , '"+guvenlikCevap+"'"
						+ " , '"+musteriNo+"' "+" , '"+sifre+"')";
		try {
			statement=connection.createStatement();
			
			if (statement.executeUpdate(sql) == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private boolean musteriNoTablodaVarmi() {

		String sql = "Select musteriNo from kullanicilar " + "where " + "musteriNo = '" + this.musteriNo + "'";

		try {
			super.statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	private String musteriNoAl() {

		do {
			this.musteriNo = String.valueOf(1000000 + (int) (Math.random() * 9000000));
		} while (musteriNoTablodaVarmi());
		return this.musteriNo;
	}

	private String musteriSifreAl() {

		this.sifre = String.valueOf(1000 + (int) (Math.random() * 9000));
		return this.sifre;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("baþvuru doGet çalýþýyor...");
		resp.sendRedirect("basvuru.jsp");

		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		adSoyad = req.getParameter("inputAdSoyad");
		tcNo = req.getParameter("inputTcNo");
		telNo = req.getParameter("inputTelNo");
		guvenlikSorusu = req.getParameter("inputGuvenlikSorusu");
		guvenlikCevap = req.getParameter("inputGuvenlikSorusuCevap");
		musteriNoAl();
		musteriSifreAl();

		
		
		if(uyeOl()) {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<script  type=\"text/javascript\">");  
			out.println("alert('Musteri Numaraniz : "+musteriNo+"   Sifreniz: "+sifre+"');");  
			out.println("location='loginController';");
			out.println("</script>");
			
			
		}else {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('TC Kimlik Numarasi Sisteme Kayitli!');");  
			out.println("location='basvuru.jsp';");
			out.println("</script>");
		}
		
		

	}

	@Override
	public boolean informationValidity() {
		if (getaAccountInfo().getMusteriNo() != null) {
			return true;
		}
		return false;
	}

	@Override
	public AccountInfo getaAccountInfo() {
		return AccountInfo.getInstance();
	}

}
