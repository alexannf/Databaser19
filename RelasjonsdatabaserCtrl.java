package com.company;

import java.sql.Statement;

public class RelasjonsdatabaserCtrl extends ConnectDB{

    // inn parametere er primary keys i databasene vi skaper relasjon i
    public void leggTilTreningsoktIkkeApparatOvelserRelasjon(String datetimeString,String ovelsesnavn) {
        try {
            Statement stmt = conn.createStatement();
            // en query vil bare være en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "insert into treningsoktHarIkkeApparatOvelse values ('"
                    + datetimeString + "', '" + ovelsesnavn +"');";
            // husk at values er på formatet '1', 'Oslo', 'Bærum' osv... (altså: husk enkeltfnutter!)
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during insertion of Treningsokt-IkkeApparatOvelse relation = " + e);
        }
    }

    // inn parametere er primary keys i databasene vi skaper relasjon i
    public void leggTilTreningsoktApparatOvelseRelasjon(String datetimeString,String ovelsesnavn) {
        try {
            Statement stmt = conn.createStatement();
            // en query vil bare være en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "insert into treningsoktHarApparatOvelse values ('"
                    + datetimeString + "', '" + ovelsesnavn +"');";
            // husk at values er på formatet '1', 'Oslo', 'Bærum' osv... (altså: husk enkeltfnutter!)
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during insertion of Treningsokt-IkkeApparatOvelse relation = " + e);
        }
    }
}
