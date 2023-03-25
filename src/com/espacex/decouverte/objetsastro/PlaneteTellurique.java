package com.espacex.decouverte.objetsastro;

import com.espacex.decouverte.enginsspatiaux.TypeVaisseau;
import com.espacex.decouverte.enginsspatiaux.Vaisseau;
import com.espacex.decouverte.enginsspatiaux.VaisseauDeGuerre;

public class PlaneteTellurique extends Planete implements Habitable{

    Vaisseau[][] vaisseauxAccostes;
    int totalVisiteurs;
    public PlaneteTellurique(String nom, int taille) {
        super(nom);
        this.vaisseauxAccostes=new Vaisseau[2][taille];
    }

    public boolean restePlaceDisponible(Vaisseau vaisseau){

        int indexZone = 0;
        switch (vaisseau.type){
            case CARGO:
            case VAISSEAUMONDE:
                indexZone = 1;
        }

        for(int index=0;index<vaisseauxAccostes[indexZone].length;index++){
            if(vaisseauxAccostes[indexZone][index]==null){
                return true;
            }
        }
        return false;
    }

    public void accueillirVaisseaux(Vaisseau... nouveauVaisseau){

        for (int j = 0; j < nouveauVaisseau.length; j++) {
            int indexZone = 0;
            switch (nouveauVaisseau[j].type){
                case CARGO:
                case VAISSEAUMONDE:
                    indexZone = 1;
            }

            for (int i = 0; i < vaisseauxAccostes[indexZone].length; i++) {
                if (vaisseauxAccostes[indexZone][i] == null) {
                    vaisseauxAccostes[indexZone][i] = nouveauVaisseau[j];
                    break;
                }
            }

            if (nouveauVaisseau[j] instanceof VaisseauDeGuerre) {
                ((VaisseauDeGuerre) nouveauVaisseau[j]).desactiverArmes();
            }

            totalVisiteurs += nouveauVaisseau[j].nbPassagers;
        }

    }
}
