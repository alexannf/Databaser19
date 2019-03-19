package com.company;

import java.sql.Statement;

public class TreningsoktCtrl extends ConnectDB{

    public void leggTilTreningsokt(int varighet, String infoOvelser, int form, int prestasjon, int stedID) {
        try {
            //this grabs the current date and time and transforms it into the correct format for datetime in SQL
            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf =
                    new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String datetime = sdf.format(dt);


            Statement stmt = conn.createStatement();
            // en query vil bare være en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "insert into treningsokt values ('"
                    + datetime + "', '" + varighet + "', '" + infoOvelser + "', '" + form + "', '" + prestasjon + "', '" + stedID +"');";
            // husk at values er på formatet '1', 'Oslo', 'Bærum' osv... (altså: husk enkeltfnutter!)
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during insertion of treningssted = " + e);
        }
    }

    public void deleteTreningsokterData(){
        try {
            Statement stmt = conn.createStatement();
            // en query vil bare være en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "delete from treningsokt;";
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during deletion of treningssted data = " + e);
        }
    }
}
