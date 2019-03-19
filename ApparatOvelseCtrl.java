package com.company;

import java.sql.Statement;

public class ApparatOvelseCtrl extends ConnectDB {

    public  void leggTilApparatOvelse(String ovelsesnavn, int antall_kilo, int antall_sett){
        try {
            Statement stmt = conn.createStatement();
            // en query vil bare være en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "insert into apparatovelse values ('" + ovelsesnavn + "', '" + antall_kilo + "', '" + antall_sett + "');";
            //husk enkeltfnutter!
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during insertion of apparatovelse = " + e);
        }
    }

    public void deleteApparatOvelserData(){
        try {
            Statement stmt = conn.createStatement();
            // en query vil bare v?re en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "delete from apparatovelse;";
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during deletion of treningssted data = " + e);
        }
    }
}
