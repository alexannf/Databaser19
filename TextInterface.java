package com.company;
import java.util.Scanner;
import TreningsstedCtrl;

public class TextInterface {


    public static void mainMenu() {
        System.out.println("Du er på: Hjem");
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv inn et tall for å gå videre.");
        System.out.println("1. Registrere apparater, øvelser og treningsøkter med tilhørende data.");
        System.out.println("2. Få opp informasjon om et antall n sist gjennomførte treningsøkter med notater, der n spesifiseres av brukeren.");
        System.out.println("3. For hver enkelt øvelse skal det være mulig å se en resultatlogg i et gitt tidsintervall spesifisert av brukeren.");
        System.out.println("4. Lage øvelsegrupper og finne øvelser som er i samme gruppe.");
        System.out.println("5. Lage (opprette) treningssteder og registrere treningssteder");
        System.out.println("0. Avslutte programmet");
        int nextPage = input.nextInt();

        if (nextPage == 1) {
            System.out.println("Du valgte: 1");
        } else if (nextPage == 1) {
            System.out.println("Du valgte: 2");
        } else if (nextPage == 1) {
            System.out.println("Du valgte: 3");
        } else if (nextPage == 1) {
            System.out.println("Du valgte: 4");

        } else if (nextPage == 1) {
            System.out.println("Du valgte: 5");

        } else if (nextPage == 1) {
            System.out.println("Du valgte: 0");

        }

    }

    public static void oppretteTreningssted() {
        System.out.println("Du er på: Opprette Treningssted");
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv inn et tall for å gå videre.");
        System.out.println("999. Avslutte programmet");

        System.out.println("Skriv inn stedsID for treningsstedet");
        int stedID = input.nextInt(); /* midlertidig */
        System.out.println("Skriv inn fylket for treningsstedet");
        String fylke = input.nextLine();
        System.out.println("Skriv inn kommunen for treningsstedet");
        String kommune = input.nextLine();
        System.out.println("Skriv inn adressen for treningsstedet");
        String adresse = input.nextLine();
        System.out.println("Skriv inn et navn/kallenavn for treningsstedet");
        String navn = input.nextLine();

        TreningsstedCtrl treningssted = new TreningsstedCtrl();
        treningssted.connect();
        treningssted.leggTilTreningssted(stedID, fylke, kommune, adresse, navn);

    }

    public static void main(String[] args) {
        mainMenu();
    }

}