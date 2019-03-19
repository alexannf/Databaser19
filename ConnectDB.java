package com.company;

	
import java.sql.Connection;
import java.sql.DriverManager;

public abstract class ConnectDB {
	protected Connection conn;
	
	// testet, funker kun med riktig scheme
	protected String scheme = "prosjektdb";  // configurer så det passer for deg
	
	// testet, funker kun med riktig brukernavn
	protected String username = "root";  // configurer så det passer for deg
	
	// testet, funker kun med riktig passord
	protected String password = "Gruppe185";  // configurer så det passer for deg
	public ConnectDB() {
		
	}
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  // added .cj, small cleanup
            conn = DriverManager.getConnection(
            		"jdbc:mysql://localhost/"+this.scheme+"?user="+this.username+"&password="+this.password+
            		// set timezone to UTC, because its the superior time format and we don't want our shit to crash
            		"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
            		+ "&autoReconnect=true");
            System.out.println(this.username + " is connected!");
		} catch (Exception e)
        {
            throw new RuntimeException("Unable to connect", e);
	        }
		}

}
