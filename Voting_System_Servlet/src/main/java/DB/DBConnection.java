package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	static Connection con;
	public static Connection openConnection() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/advjava?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		con=DriverManager.getConnection(url,"root","root");
		return con;
	}
	public static void closeConnection() throws SQLException
	{
		if(con!=null)
		{
			con.close();
		}
	}

}
