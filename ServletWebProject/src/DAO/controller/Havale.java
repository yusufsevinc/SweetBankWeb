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

@WebServlet("/havale")
public class Havale extends ConnectionDAO implements IInfoControl {
	public static boolean test2(int miktar) {
		if (miktar == 10) {
			return true;

		}
		return false;
	}

	public boolean havaleYap(String musteriNo, int miktar) {
		String sql1 = "update kullanici_bakiye set bakiye = bakiye - '" + miktar + "' where kullaniciId  = '"
				+ getaAccountInfo().getKullaniciId() + "'";

		String sql2 = "update kullanici_bakiye set bakiye = bakiye + '" + miktar + "'" + " where musteriNo = '"
				+ musteriNo + "' and musteriNo != '" + getaAccountInfo().getMusteriNo() + "'";

		try {
			super.statement = super.connection.createStatement();
			if (statement.executeUpdate(sql2) == 1) {
				statement.executeUpdate(sql1);
				return true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
		System.out.println("havale do get çalýþtý");
		if (informationValidity()) {
			
			System.out.println("müþteri no :  "+getaAccountInfo().getMusteriNo() );
			req.setAttribute("bakiye", getaAccountInfo().getBakiye());

			RequestDispatcher dispatcher = req.getRequestDispatcher("havale.jsp");
			dispatcher.forward(req, resp);
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean kontrol = false;
		int miktar = Integer.parseInt(req.getParameter("miktar"));
		String musteriNo = req.getParameter("musteriNo");
		System.out.println("müþterino:"+musteriNo);
		if (havaleYap(musteriNo ,miktar)) {
			
			System.out.println(miktar);
			System.out.println("metod doðru");
			req.setAttribute("test", true);

		} else {
			System.out.println("metod yanlýþ");
			req.setAttribute("test", false);
		}
        
		kontrol = (boolean) req.getAttribute("test");
		
		if (kontrol) {
			getaAccountInfo().setBakiye(getaAccountInfo().getBakiye() - miktar);
			resp.sendRedirect("mainMenu");
		}else {
			req.setAttribute("error", "Müþteri No kontrol edip tekrar deneyiniz !");
			doGet(req, resp);
		}

	}

	@Override
	public boolean informationValidity() {
		// TODO Auto-generated method stub
		if (getaAccountInfo().getMusteriNo() != null || getaAccountInfo().getTcNo() != null) {
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
