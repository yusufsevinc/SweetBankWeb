package DAO.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.Data;

public class AccountInfo extends Data {

	private static AccountInfo accountInfo = null;

	public static AccountInfo getInstance(){
		if (accountInfo == null) {
			accountInfo = new AccountInfo();
			System.out.println("hesap oluþtu ...");
			return accountInfo;

		}
		return accountInfo;
	}

	private AccountInfo() {

	}
	
	
	public void girisYap(String musteriNo) {
		kullaniciAl(musteriNo);
		faturalarýAl();
		bakiyeAl();
	}
	

	private void kullaniciAl(String musteriNo) {
        String sql = "Select * from kullanicilar WHERE "
                + "tcNo = '" + musteriNo + "'"
                + " OR "
                + "musteriNo = '" + musteriNo + "'";
        try {
            super.statement = super.connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {

                super.adSoyad = rs.getNString("adSoyad");
                super.tcNo = rs.getNString("tcNo");
                super.telNo = rs.getNString("telNo");
                super.musteriNo = rs.getNString("musteriNO");
                super.kullaniciId = rs.getInt("kullaniciId");
               
               

            }
        } catch (Exception e) {
        	System.out.println("HATA:  " + e);
        }

    }
	
	
	
	public void faturalarýAl() {
		
		String sql = "Select * from kullanici_faturalar where "
				+ "kullaniciId = '" + kullaniciId + "'";
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				elektrikFaturasi = rs.getDouble("elektrik");
				suFaturasi = rs.getDouble("su");
				dogalgazFaturasi = rs.getDouble("dogalgaz");
				internetFaturasi = rs.getDouble("internet");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private void bakiyeAl(){
		String sql = "Select * from kullanici_bakiye "
				+ "where kullaniciId = '" + kullaniciId + "'";
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				bakiye = rs.getDouble("bakiye");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	

	

}
