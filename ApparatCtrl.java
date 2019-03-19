package com.company;

import java.sql.Statement;
import java.sql.ResultSet;

public class ApparatCtrl extends ConnectDB{


    // oppretter på riktig måte
    public  void leggTilApparat(String navn, String beskrivelse){
        try {
            Statement stmt = conn.createStatement();
            // en query vil bare v?re en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "insert into apparat values ('" + navn + "', '" + beskrivelse + "');";
            //husk enkeltfnutter!
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // m? bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during insertion of apparat = " + e);
        }
    }

    public void deleteApparaterData(){
        try {
            Statement stmt = conn.createStatement();
            // en query vil bare v?re en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "delete from apparat;";
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during deletion of treningssted data = " + e);
        }
    }
}
