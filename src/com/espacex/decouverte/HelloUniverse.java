package com.espacex.decouverte;

import com.espacex.decouverte.enginsspatiaux.*;
import com.espacex.decouverte.objetsastro.*;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.*;

public class HelloUniverse {

    public static void main(String... args) {

        Galaxie systemeSolaire = new Galaxie();
        systemeSolaire.nom = "Système solaire";

        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 1);
        mercure.diametre = 4880;
        mercure.distanceEtoile = 57.9f;
        systemeSolaire.planetes.add(mercure);
        PlaneteTellurique venus = new PlaneteTellurique("Venus", 2);
        venus.diametre = 12100;
        venus.distanceEtoile = 108.2f;
        systemeSolaire.planetes.add(venus);
        PlaneteTellurique terre = new PlaneteTellurique("Terre", 100);
        terre.diametre = 12756;
        terre.distanceEtoile = 149.6f;
        systemeSolaire.planetes.add(terre);
        PlaneteTellurique mars = new PlaneteTellurique("Mars", 5);
        mars.diametre = 6792;
        mars.distanceEtoile = 227.9f;
        systemeSolaire.planetes.add(mars);
        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;
        jupiter.distanceEtoile = 778.3f;
        systemeSolaire.planetes.add(jupiter);
        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        saturne.distanceEtoile = 1427.0f;
        systemeSolaire.planetes.add(saturne);
        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        uranus.distanceEtoile = 2877.38f;
        systemeSolaire.planetes.add(uranus);
        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;
        neptune.distanceEtoile = 4497.07f;
        systemeSolaire.planetes.add(neptune);

        System.out.println("La galaxie est constituée de :");
        for (Planete p:
             systemeSolaire.planetes) {
            System.out.println(p.nom);
        }

        Atmosphere atmosphereMars = new Atmosphere();
        atmosphereMars.constituants.put("CO2", 95f);
        atmosphereMars.constituants.put("N2", 3f);
        atmosphereMars.constituants.put("AR", 1.5f);
        atmosphereMars.constituants.put("NO", 0.013f);

        mars.atmosphere = atmosphereMars;
        System.out.println("L'atmosphère de Mars est constituée de :");
        for (Map.Entry<String, Float> constituant: mars.atmosphere.constituants.entrySet()
             ) {
            System.out.println(constituant.getValue()+"% de "+constituant.getKey());
        }

        Vaisseau chasseur = new VaisseauDeGuerre(CHASSEUR);
        chasseur.nbPassagers = 3;
        chasseur.blindage = 156;
        chasseur.resistanceDuBouclier = 2;

        Vaisseau croiseur = new VaisseauDeGuerre(CROISEUR);
        croiseur.nbPassagers = 35;
        croiseur.blindage = 851;
        croiseur.resistanceDuBouclier = 25;

        Vaisseau fregate = new VaisseauDeGuerre(FREGATE);
        fregate.nbPassagers = 100;
        fregate.blindage = 542;
        fregate.resistanceDuBouclier = 50;

        Vaisseau cargo = new VaisseauCivil(CARGO);
        cargo.nbPassagers = 10000;
        cargo.blindage = 1520;
        cargo.resistanceDuBouclier = 20;

        Vaisseau vaisseauMonde = new VaisseauCivil(VAISSEAUMONDE);
        vaisseauMonde.nbPassagers = 10000;
        vaisseauMonde.blindage = 4784;
        vaisseauMonde.resistanceDuBouclier = 30;

        Vaisseau chasseur2 = new VaisseauDeGuerre(CHASSEUR);
        chasseur2.nbPassagers = 4;
        chasseur2.blindage = 156;
        chasseur2.resistanceDuBouclier = 2;
        Vaisseau chasseur3 = new VaisseauDeGuerre(CHASSEUR);
        chasseur3.nbPassagers = 5;
        chasseur3.blindage = 156;
        chasseur3.resistanceDuBouclier = 2;
        Vaisseau cargo2 = new VaisseauCivil(CARGO);
        cargo2.nbPassagers = 10001;
        cargo2.blindage = 1520;
        cargo2.resistanceDuBouclier = 20;
        terre.accueillirVaisseaux(chasseur2,chasseur3,cargo2);

        Scanner sc = new Scanner(System.in);
        boolean recommencer = true;
        while (recommencer) {
            System.out.println("Quel vaisseau souhaitez vous manipuler: " + CHASSEUR.name() + ", " + FREGATE.name() + ", " + CROISEUR.name() + ", " + CARGO.name() + " ou " + VAISSEAUMONDE.name() + " ?");
            String typeVaisseauSelectionne = sc.nextLine();

            System.out.println("Sur quelle planète tellurique du systeme solaire voulez-vous vous poser : Mercure, Venus, Terre ou Mars ?");
            String nomPlanete = sc.nextLine();

            System.out.println("Quel tonnage souhaitez-vous emporter ?");
            int tonnageSouhaite;
            while (true) {
                try {
                    tonnageSouhaite = sc.nextInt();
                    break;
                } catch (InputMismatchException i) {
                    System.out.println("Le tonnage n'est pas numérique");
                }
                finally {
                    sc.nextLine();
                }
            }

            TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(typeVaisseauSelectionne);
            Vaisseau vaisseauSelectionne = null;
            switch (typeVaisseau) {
                case CHASSEUR:
                    vaisseauSelectionne = chasseur;
                    break;
                case FREGATE:
                    vaisseauSelectionne = fregate;
                    break;
                case CROISEUR:
                    vaisseauSelectionne = croiseur;
                    break;
                case CARGO:
                    vaisseauSelectionne = cargo;
                    break;
                case VAISSEAUMONDE:
                    vaisseauSelectionne = vaisseauMonde;
                    break;
            }
            Planete planeteSelectionne=null;
            for (Planete p:systemeSolaire.planetes
                 ) {
                if (p.nom == nomPlanete){
                    planeteSelectionne=p;
                    break;
                }
            }

            if (planeteSelectionne instanceof PlaneteGazeuse){
                System.out.println("La planète sélectionnée n'est pas une planète tellurique, veuillez recommencer.");
                continue;
            }

            PlaneteTellurique planete = (PlaneteTellurique)planeteSelectionne ;

            if (planete.restePlaceDisponible(vaisseauSelectionne)) {
                planete.accueillirVaisseaux(vaisseauSelectionne);
                try {
                    vaisseauSelectionne.emporterCargaison(tonnageSouhaite);
                } catch (DepassementTonnageException e) {
                    System.out.println("Le vaisseau a rejeté : "+e.tonnageEnExces+" tonnes.");
                    System.out.println("Voulez-vous emporter un tonnage partiel à la hauteur de "+(tonnageSouhaite-e.tonnageEnExces)+" (oui/non)");
                    String accepte = sc.nextLine();
                    if (accepte.equals("oui")) {
                        try {
                            vaisseauSelectionne.emporterCargaison(tonnageSouhaite-e.tonnageEnExces);
                        } catch (DepassementTonnageException ex) {
                            System.out.println("Erreur inattendue");
                        }
                    } else {
                        System.out.println("Opération annulée");
                    }
                }
            } else {
                System.out.println("Le vaisseau ne peut pas se poser sur la planète par manque de place dans la baie.");
            }

            System.out.println("Voulez-vous recommencer oui/non ?");

            recommencer = sc.nextLine().equals("oui");

        }
    }

}
