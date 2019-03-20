package com.company;
import java.util.Scanner;

public class TextInterface {

    public static void mainMenu() {
        System.out.println("Du er på: Hjem");
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv inn et tall for å gå videre.");
        System.out.println("1. Registrere apparater, øvelser og treningsøkter med tilhørende data.");
        System.out.println("2. Få opp informasjon om et antall n sist gjennomførte treningsøkter med notater, der n spesifiseres av brukeren.");
        System.out.println("3. For hver enkelt øvelse skal det være mulig å se en resultatlogg i et gitt tidsintervall spesifisert av brukeren.");
        System.out.println("4. Lage øvelsegrupper og finne øvelser som er i samme gruppe.");
        System.out.println("9. Slette alt fra databasen");
        System.out.println("0. Avslutte programmet");
        int nextPage = input.nextInt();
        cancel(nextPage);

        if (nextPage == 1) {
            registrereMeny();
        } else if (nextPage == 2) {
            visAntallTreningsokter();
        } else if (nextPage == 3) {
            System.out.println("Du valgte: 3");
        } else if (nextPage == 4) {
            System.out.println("Du valgte: 4");
        } else if (nextPage == 5) {
            System.out.println("Du valgte: 5");
        } else if (nextPage == 9) {
            clear_database();
        } else if (nextPage == 0) {
            System.exit(0);
        }

    }

    public static void cancel(String input) {
        try {
            if (Integer.valueOf(input) == 999) {
                mainMenu();
            }
        } catch (NumberFormatException e) {

        }

    }

    public static void cancel(int input) {
        if (input == 999) {
            mainMenu();
        }
    }

    public static void clear_database() {
        TreningsoktCtrl treningsokt = new TreningsoktCtrl();
        treningsokt.connect();
        treningsokt.deleteTreningsokterData();

        TreningsstedCtrl treningssted = new TreningsstedCtrl();
        treningssted.connect();
        treningssted.deleteTreningsstederData();

        ApparatCtrl apparat = new ApparatCtrl();
        apparat.connect();
        apparat.deleteApparaterData();

        ApparatOvelseCtrl apparatOvelse = new ApparatOvelseCtrl();
        apparatOvelse.connect();
        apparatOvelse.deleteApparatOvelserData();

        IkkeApparatOvelseCtrl ikkeApparatOvelse = new IkkeApparatOvelseCtrl();
        ikkeApparatOvelse.connect();
        ikkeApparatOvelse.deleteIkkeApparatOvelserData();
    }

    public static void registrereMeny() {
        System.out.println("Du er på: Meny");
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv inn et tall for å gå videre.");
        System.out.println("1. Registrere treningsøkt");
        System.out.println("2. Opprette treningssted");
        System.out.println("3. Opprette apparat");
        System.out.println("4. Opprette øvelse");
        System.out.println("999. Gå til hovedmenyen (Kan skrives til ethvert tidspunkt)");

        int nextPage = input.nextInt();
        cancel(nextPage);

        if (nextPage == 1) {
            treningsokt();
        } else if (nextPage == 2) {
            oppretteTreningssted();
        } else if (nextPage == 3) {
            oppretteApparat();
        } else if (nextPage == 4) {
            opppretteOvelse();
        }

    }

    public static void visAntallTreningsokter() {
        System.out.println("Du er på: Visning av treningsøkter");
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv inn antall treningsøkter du vil se. (999 for å gå til hovedmenyen)");
        int antall = input.nextInt();
        cancel(antall);

        TreningsoktCtrl treningsokt = new TreningsoktCtrl();
        treningsokt.connect();

        treningsokt.printAntallTreningsokter(antall);
    }

    public static void oppretteTreningssted() {
        System.out.println("Du er på: Opprette Treningssted");
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv inn et tall for å gå videre.");
        System.out.println("999. Gå til hovedmenyen (Kan skrives til ethvert tidspunkt)");

        System.out.println("Skriv inn stedsID for treningsstedet (int)");
        int stedID = input.nextInt(); /* midlertidig */
        input.nextLine();
        cancel(stedID);
        System.out.println("Skriv inn fylket for treningsstedet (string)");
        String fylke = input.nextLine();
        cancel(fylke);
        System.out.println("Skriv inn kommunen for treningsstedet (string)");
        String kommune = input.nextLine();
        cancel(kommune);
        System.out.println("Skriv inn adressen for treningsstedet (string)");
        String adresse = input.nextLine();
        cancel(adresse);
        System.out.println("Skriv inn et navn/kallenavn for treningsstedet (string)");
        String navn = input.nextLine();
        cancel(navn);

        TreningsstedCtrl treningssted = new TreningsstedCtrl();
        treningssted.connect();
        treningssted.leggTilTreningssted(stedID, fylke, kommune, adresse, navn);
    }

    public static void oppretteApparat() {
        System.out.println("Du er på: Legge til Apparat");
        Scanner input = new Scanner(System.in);
        System.out.println("999. Gå til hovedmenyen (Kan skrives til ethvert tidspunkt)");

        System.out.println("Skriv inn et navn for apparatet");
        String navn = input.nextLine();
        cancel(navn);
        System.out.println("Skriv inn en beskrivelse for apparatet");
        String beskrivelse = input.nextLine();
        cancel(beskrivelse);

        ApparatCtrl apparat = new ApparatCtrl();
        apparat.connect();
        apparat.leggTilApparat(navn, beskrivelse);
    }

    public static void treningsokt() {
        System.out.println("Du er på: Legge til Treningssøkt");
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv inn et tall for å gå videre.");
        System.out.println("999. Gå til hovedmenyen (Kan skrives til ethvert tidspunkt)");

        System.out.println("Skriv inn varigheten for treningsøkten");
        int varighet = input.nextInt();
        input.nextLine();
        cancel(varighet);
        System.out.println("Skriv inn informasjon om øvelser");
        String infoOvelser = input.nextLine();
        cancel(infoOvelser);
        System.out.println("Skriv inn form (1-10)");
        int form = input.nextInt();
        input.nextLine();
        cancel(form);
        System.out.println("Skriv inn prestasjon (1-10)");
        int prestasjon = input.nextInt();
        input.nextLine();
        cancel(prestasjon);

        System.out.println("Skriv inn stedID");
        TreningsstedCtrl treningssted = new TreningsstedCtrl();
        treningssted.connect();
        treningssted.printTreningssteder();
        int stedID = input.nextInt();
        input.nextLine();
        cancel(stedID);

        TreningsoktCtrl treningsokt = new TreningsoktCtrl();
        treningsokt.connect();
        treningsokt.leggTilTreningsokt(varighet, infoOvelser, form, prestasjon, stedID);
    }


    public static void opppretteOvelse() {
        System.out.println("Du er på: Opprette Treningssted");
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv inn et tall for å gå videre.");
        System.out.println("1. Apparat Øvelse");
        System.out.println("2. Ikke-apparat Øvelse");
        System.out.println("999. Gå til hovedmenyen (Kan skrives til ethvert tidspunkt)");

        int nextPage = input.nextInt();
        cancel(nextPage);
        if (nextPage == 1) {
            oppretteApparatOvelse();
        } else if (nextPage == 2) {
            oppretteIkkeApparatOvelse();
        }
    }

    public static void oppretteApparatOvelse() {
        System.out.println("Du er på: Opprette Treningssted");
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv inn et tall for å gå videre.");
        System.out.println("999. Gå til hovedmenyen (Kan skrives til ethvert tidspunkt)");

        System.out.println("Skriv inn navn for apparat øvelsen");
        String ovelsesnavn = input.nextLine();
        cancel(ovelsesnavn);
        System.out.println("Skriv inn antall kilo for apparat øvelsen");
        int antall_kilo = input.nextInt();
        input.nextLine();
        cancel(antall_kilo);
        System.out.println("Skriv inn antall sett for apparat øvelsen");
        int antall_sett = input.nextInt();
        input.nextLine();
        cancel(antall_sett);

        ApparatOvelseCtrl apparatOvelse = new ApparatOvelseCtrl();
        apparatOvelse.connect();
        apparatOvelse.leggTilApparatOvelse(ovelsesnavn, antall_kilo, antall_sett);
    }

    public static void oppretteIkkeApparatOvelse() {
        System.out.println("Du er på: Opprette Treningssted");
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv inn et tall for å gå videre.");
        System.out.println("999. Gå til hovedmenyen (Kan skrives til ethvert tidspunkt)");

        System.out.println("Skriv inn navn for ikke-apparat øvelsen");
        String ovelsesnavn = input.nextLine();
        cancel(ovelsesnavn);
        System.out.println("Skriv inn beskrivelse for ikke-apparat øvelsen");
        String beskrivelse = input.nextLine();
        cancel(beskrivelse);

        IkkeApparatOvelseCtrl ikkeApparatOvelse = new IkkeApparatOvelseCtrl();
        ikkeApparatOvelse.connect();
        ikkeApparatOvelse.leggTilIkkeApparatOvelse(ovelsesnavn, beskrivelse);
    }

    public static void main(String[] args) {
        mainMenu();
    }

}