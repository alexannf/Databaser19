package com.company;

import java.sql.Statement;

public class OvelsegruppeCtrl extends ConnectDB{

    public void opprettTreningsgruppe(String navn){
        try {
            Statement stmt = conn.createStatement();
            // en query vil bare være en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "insert into ovingsgruppe values ('" + navn + "');";
            //husk enkeltfnutter!
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during insertion of apparat = " + e);
        }
    }

    public void leggTilOvelseIGruppe(){
        
    }
}
