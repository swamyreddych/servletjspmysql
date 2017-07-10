package com.swaminadh.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Dbutil {
	private static Connection connection = null ;
public static Connection getConnection(){
	 
	if (connection  != null){
		return connection;
	}
	else {
	try {
		Properties p = new Properties ();
		InputStream inputstream = Dbutil.class.getClassLoader().getResourceAsStream("/db.properties");
		p.load(inputstream);
		String driver = p.getProperty("driver");
        String url = p.getProperty("url");
        String user = p.getProperty("user");
        String password = p.getProperty("password");
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
		
	} catch(ClassNotFoundException e){
		e.printStackTrace();	
	} 
	catch (SQLException e) {
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();		
	}
	return connection;
}
}

}
