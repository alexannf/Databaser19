package com.company;

import java.sql.Statement;

public class IkkeApparatOvelseCtrl extends ConnectDB{

    public  void leggTilIkkeApparatOvelse(String ovelsesnavn, String beskrivelse){
        try {
            Statement stmt = conn.createStatement();
            // en query vil bare være en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "insert into ikkeapparatovelse values ('" + ovelsesnavn + "', '" + beskrivelse + "');";
            //husk enkeltfnutter!
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during insertion of apparatovelse = " + e);
        }
    }

    public void deleteIkkeApparatOvelserData(){
        try {
            Statement stmt = conn.createStatement();
            // en query vil bare v?re en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "delete from ikkeapparatovelse;";
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during deletion of treningssted data = " + e);
        }
    }
}
