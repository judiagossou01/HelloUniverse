package com.espacex.decouverte.objetsastro;

import java.util.Objects;

public abstract class Planete implements Comparable{
    public String nom;
    public long diametre;
    int totalVisiteurs;
    public float distanceEtoile;
    public Atmosphere atmosphere;

    static int nbPlaneteDecouvertes;

    Planete(String nom) {
        this.nom = nom;
        nbPlaneteDecouvertes++;
    }

    public final int revolution(int degres){
        System.out.println("Je suis la planète "+nom+" et je tourne autour de mon étoile de "+degres+" degrés.");
        return degres/360;
    }

    public final int rotation(int degres){
        System.out.println("Je suis la planète "+nom+" et je tourne sur moi-même de "+degres+" degrés.");
        return degres/360;
    }

    static String expansion (double milliardsDAnneesLumiere){
        if (milliardsDAnneesLumiere < 14){
            return "Oh la la mais c'est super rapide !";
        }
        else {
            return "Je rêve ou c'est plus rapide que la lumière ?";
        }
    }

    public int compareTo(Object o){
        Planete autrePlanete = (Planete) o;
        return ((Float)distanceEtoile).compareTo(autrePlanete.distanceEtoile);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Planete)){
            return false;
        }
        Planete autrePlanete = (Planete) obj;
        return nom==autrePlanete.nom;
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }
}
