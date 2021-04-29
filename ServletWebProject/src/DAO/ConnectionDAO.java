package DAO;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ConnectionDAO extends HttpServlet{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String host = "localhost";
    private final String port = "3306";
    private final String veritabaniAdi = "sweetbank";
    private final String user = "root";
    private final String password = "";    

    protected Connection connection = null;
    protected Statement statement = null;

    public ConnectionDAO() {
    
       String url = "jdbc:mysql://"+this.host+":"+this.port+"/"+this.veritabaniAdi;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Baðlantý baþarýlý....");
        } catch (SQLException e) {
        	System.out.println("Hata:  " +e);
            errorException(e.getMessage(),e.getErrorCode());
            System.out.println("Baðlantý baþarýsýz....");
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
        	System.out.println("Hata:  " +e);
		}
        
    }//CONSTRUCTOR
    
    public static void errorException(String exception ){
        System.out.println("Hata : " +exception );
    
    }
     public static void errorException(String exception ,int errorCode ){
        System.err.println("Hata : " +exception );
    System.err.println("Hata Kodu : " +errorCode );
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
    
    
}//CLASS

