package com.espacex.decouverte.enginsspatiaux;

import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CHASSEUR;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.FREGATE;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CROISEUR;

public class VaisseauDeGuerre extends Vaisseau {

    private boolean armesDesactivees;

    public VaisseauDeGuerre(TypeVaisseau type){
        super(type);

        if (type==CHASSEUR){
            tonnageMax=0;
        }
        else if (type==FREGATE){
            tonnageMax=50;
        }
        else if (type==CROISEUR){
            tonnageMax=100;
        }

    }

    public void attaque(Vaisseau vaisseauCible, String arme, int duree) {
        if (armesDesactivees) {
            System.out.println("Attaque impossible, l'armement est désactivé");
        } else {
            System.out.println("Un vaisseau de type " + type.nom + " attaque un vaisseau de type " + vaisseauCible.type.nom + " en utilisant l'arme " + arme + " pendant " + duree + " minutes.");
            vaisseauCible.resistanceDuBouclier = 0;
            vaisseauCible.blindage = vaisseauCible.blindage / 2;
        }
    }

    public void desactiverArmes() {
        System.out.println("Désactivation des armes d'un vaisseau de type " + type.nom);
        armesDesactivees = true;
    }

    public void activerArmes() {
        System.out.println("Activation des armes d'un vaisseau de type " + type.nom);
        armesDesactivees = false;
    }

    public void activerBouclier(){
        System.out.println("Activation du bouclier d'un vaisseau de type "+type.nom+".");
        desactiverArmes();
    }

    public void emporterCargaison (int cargaison) throws DepassementTonnageException {
        if (type==CHASSEUR){
            throw new DepassementTonnageException(cargaison);
        }
        else {
            if (nbPassagers<12){
                throw new DepassementTonnageException(cargaison);
            }
            else {
                int tonnagePassagers=nbPassagers*2;
                int tonnageRestant=tonnageMax-tonnageActuel;
                int tonnageAConsiderer=(tonnagePassagers<tonnageRestant ? tonnagePassagers : tonnageRestant);
                if (cargaison>tonnageAConsiderer){
                    int tonnageEnExces = cargaison-tonnageAConsiderer;
                    throw new DepassementTonnageException(tonnageEnExces);
                }
                else {
                    tonnageActuel+=cargaison;
                }
            }
        }
    }
}
