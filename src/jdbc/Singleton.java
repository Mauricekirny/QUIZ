
package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton
{
	 private static  Singleton instance;
	  private Connection connection;
	  private String url = "jdbc:mysql://localhost:3306/quiz";
	  private String username = "root";
	  private String password = "root";
	  private  Singleton() throws SQLException {
	    try {
	      Class.forName("org.mysql.Driver");
	      this.connection = DriverManager.getConnection(url, username, password);
	    } 
	    catch (ClassNotFoundException ex) {
	      System.out.println("Something is wrong with the DB connection String : " + ex.getMessage());
	    }
	  }
	  public Connection getConnection() {
	    return connection;
	  }
	  public static  Singleton getInstance() throws SQLException {
	    if (instance == null) {
	      instance = new  Singleton();
	    } 
	    else if (instance.getConnection().isClosed()) {
	      instance = new  Singleton();
	    }
	    
	    return instance; 
	}
}