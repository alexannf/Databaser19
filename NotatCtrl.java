package com.company;

import java.sql.Statement;

public class NotatCtrl extends ConnectDB {

    public  void leggTilNotat(String treningsoktID, String beskrivelse){
        try {
            Statement stmt = conn.createStatement();
            // en query vil bare v?re en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "insert into notat values ('" + treningsoktID + "', '" + beskrivelse + "');";
            //husk enkeltfnutter!
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // m? bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during insertion of notat = " + e);
        }
    }

    public void deleteNotaterData(){
        try {
            Statement stmt = conn.createStatement();
            // en query vil bare v?re en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "delete from notat;";
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during deletion of notater data = " + e);
        }
    }
}
