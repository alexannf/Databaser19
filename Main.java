package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    // enkel test for å sjekke om den abstrakte klassen funker og for å sjekke kobling mot databasen (connect)
        /*
        Test test = new Test();
        test.connect();

        TreningsstedCtrl treningssted = new TreningsstedCtrl();
        ApparatOvelseCtrl apparatovelse = new ApparatOvelseCtrl();
        apparatovelse.connect();
        apparatovelse.deleteApparatOvelserData();
        apparatovelse.leggTilApparatOvelse("benkpress",5,5);
        // må alltid calle(instansiere) connect før vi kommuniserer med databasen, hvis ikke får vi en nullpointer error

        treningssted.connect();
        treningssted.deleteTreningsstederData();
        treningssted.printTreningssteder();
        treningssted.leggTilTreningssted(1, "Akershus", "Asker", "Sætre Terrasse 17", "Alexander sin $teke crib");
        treningssted.leggTilTreningssted(2, "Trøndelag", "Trondheim", "Arkitekt Christies gate 11", "Alexander sin studentcrib");
        treningssted.printTreningssteder();

        //funker å legge til i databasen
        IkkeApparatOvelseCtrl iao = new IkkeApparatOvelseCtrl();
        iao.connect();
        iao.deleteIkkeApparatOvelserData();
        iao.leggTilIkkeApparatOvelse("push ups", "stå i planke, senk deg ned til gulvet, dytt opp");
        */


        System.out.println("You made it to this point against all odds, congrats");

    }
}

