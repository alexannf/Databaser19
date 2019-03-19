package com.company;

import java.sql.ResultSet;
import java.sql.Statement;

public class TreningsstedCtrl extends ConnectDB{
	
	public void leggTilTreningssted(int StedID, String Fylke, String Kommune, String Adresse, String Navn) {
		try {
			// "conn" er hentet fra den abstrakte klassen og brukes i alle sammenhenger der vi må kommunisere med databasen
			// vi har instansiert stmt med conn så vi får en statement som er connected til databasen (men som ikke har gjort noe enda)
			Statement stmt = conn.createStatement();
			// en query vil bare være en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
			String query = "insert into treningssted values ('" + StedID + "', '" + Fylke + "', '" + Kommune + "', '" + Adresse + "', '" + Navn +"');"; 
			// husk at values er på formatet '1', 'Oslo', 'Bærum' osv... (altså: husk enkeltfnutter!)
			System.out.println("følgende spørring ble utført: "+query);
			System.out.println();
			// må bruke executeUpdate for INSERT, DELETE og UPDATE statements
			stmt.executeUpdate(query);
			
			
		} catch (Exception e) {
            System.out.println("db error during insertion of treningssted = " + e);
        }
	}
	
	public void printTreningssteder() {
		try {
		Statement stmt = conn.createStatement();
		String query = "select * from treningssted";
		System.out.println("følgende spørring ble utført: "+query);
		System.out.println();
		// må bruke executeQuery for spørringer, de returnerer et ResultSet (en slags liste vi kan iterere over))
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("Følgende treningssteder er lagt til:");
		System.out.println("| StedID | Fylke | Kommune | Adresse | Navn |");
		while(rs.next()) {
			System.out.println("| "+rs.getString("StedID")+" | "+rs.getString("Fylke")+" | "+rs.getString("Kommune")+" | "
					+rs.getString("Adresse")+" | "+rs.getString("Navn") + " |");
		}
		System.out.println();
		
		
		} catch (Exception e) {
	        System.out.println("db error during selection of treningssted = " + e);
	    }
	}

	public void deleteTreningsstederData(){
		try {
			// "conn" er hentet fra den abstrakte klassen og brukes i alle sammenhenger der vi m� kommunisere med databasen
			// vi har instansiert stmt med conn s� vi f�r en statement som er connected til databasen (men som ikke har gjort noe enda)
			Statement stmt = conn.createStatement();
			// en query vil bare v�re en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
			String query = "delete from treningssted;";
			System.out.println("f�lgende sp�rring ble utf�rt: "+query);
			System.out.println();
			// m� bruke executeUpdate for INSERT, DELETE og UPDATE statements
			stmt.executeUpdate(query);


		} catch (Exception e) {
			System.out.println("db error during deletion of treningssted data = " + e);
		}
	}
	
	
}
