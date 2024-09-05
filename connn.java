package hospital.management.system;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class connn 
{
	Connection connection;
	Statement statement;
	

	public connn()
	{
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root","root");
			 statement=connection.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
