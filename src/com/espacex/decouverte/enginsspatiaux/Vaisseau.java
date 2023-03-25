package com.espacex.decouverte.enginsspatiaux;

public abstract class Vaisseau {
    public final TypeVaisseau type;
    public int nbPassagers;
    public int blindage;
    public int resistanceDuBouclier;
    int tonnageMax;
    protected int tonnageActuel;

    public Vaisseau(TypeVaisseau type) {
        this.type = type;
    }

    void activerBouclier(){
        System.out.println("Activation du bouclier d'un vaisseau de type "+this.type);
    }

    void desactiverBouclier(){
        System.out.println("Désactivation du bouclier d'un vaisseau de type "+this.type);
    }

     public abstract void emporterCargaison (int tonnage) throws DepassementTonnageException;
}
