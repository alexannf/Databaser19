package com.company;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

    public void printAntallTreningsokter(int antall) {
        try {
            Statement stmt = conn.createStatement();
            String query = "select * from treningsokt order by TreningsoktID desc;";
            System.out.println("følgende spørring ble utført: "+query);
            System.out.println();
            // må bruke executeQuery for spørringer, de returnerer et ResultSet (en slags liste vi kan iterere over))
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<String> treningsokter = new ArrayList<String>();
            System.out.println("Følgende treninsøkter er lagt til:");
            System.out.println("| Varighet | InfoOmOvelser | Form | Prestasjon | StedID |");
            while(rs.next()) {
                if (treningsokter.size() == antall) {
                    break;
                }
                treningsokter.add("| "+rs.getString("Varighet")+" | "+rs.getString("InfoOmOvelser")+" | "+rs.getString("Form")+" | "
                        +rs.getString("Prestasjon")+" | "+rs.getString("StedID") + " |");

            }

            treningsokter.forEach(treningsokt->System.out.println(treningsokt));


        } catch (Exception e) {
            System.out.println("db error during selection of treningsøkt = " + e);
        }
    }
}
