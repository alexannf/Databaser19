package com.company;

import java.sql.ResultSet;
import java.sql.Statement;

public class OvelsegruppeCtrl extends ConnectDB{

    public void opprettOvelsesgruppe(String navn){
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
    //
    public void leggTilApparatOvelseIGruppe(String ovelse, String ovelsesgruppe){
        try {
            Statement stmt = conn.createStatement();
            // en query vil bare være en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "insert into ovingsgruppeharapparatovelse values ('" + ovelsesgruppe + "', '" + ovelse + "');";
            //husk enkeltfnutter!
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during insertion of apparat = " + e);
        }
    }

    public void leggTilIkkeApparatOvelseIGruppe(String ovelse, String ovelsesgruppe){
        try {
            Statement stmt = conn.createStatement();
            // en query vil bare være en lang string i riktig format (ikke glem semikolon i queryStringen :)    )
            String query = "insert into ovingsgruppeharikkeapparatovelse values ('" + ovelsesgruppe + "', '" + ovelse + "');";
            //husk enkeltfnutter!
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeUpdate for INSERT, DELETE og UPDATE statements
            stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("db error during insertion of apparat = " + e);
        }
    }

    public void seOvelserIGruppe(String gruppe){
        try {
            Statement stmt = conn.createStatement();
            String query = "select ovingsgruppe.Gruppenavn, ovingsgruppeharapparatovelse.OvelsesNavn\n" +
                    "from ovingsgruppe inner join ovingsgruppeharapparatovelse on \n" +
                    "(ovingsgruppe.Gruppenavn = ovingsgruppeharapparatovelse.Gruppenavn)\n" +
                    "where ovingsgruppe.Gruppenavn = '"+ gruppe + "'\n" +
                    "union\n" +
                    "select ovingsgruppe.Gruppenavn, ovingsgruppeharikkeapparatovelse.OvelsesNavn\n" +
                    "from ovingsgruppe inner join ovingsgruppeharikkeapparatovelse on \n" +
                    "(ovingsgruppe.Gruppenavn = ovingsgruppeharikkeapparatovelse.Gruppenavn)\n" +
                    "where ovingsgruppe.Gruppenavn = '"+ gruppe + "';";
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeQuery for spørringer, de returnerer et ResultSet (en slags liste vi kan iterere over))
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Følgende øvelser er i "+gruppe+" :");
            System.out.println("| Gruppenavn | Øvelsesnavn |");
            while(rs.next()) {
                System.out.println("| "+rs.getString("Gruppenavn")+" | "+rs.getString("OvelsesNavn")+" |");
            }
            System.out.println();


        } catch (Exception e) {
            System.out.println("db error during selection of treningssted = " + e);
        }
    }
}
