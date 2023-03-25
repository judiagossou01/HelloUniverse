package com.espacex.decouverte.enginsspatiaux;

import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CARGO;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.VAISSEAUMONDE;

public class VaisseauCivil extends Vaisseau {

    public VaisseauCivil(TypeVaisseau type){
        super(type);

        if (type == CARGO) {
            tonnageMax = 500;
        } else if (type == VAISSEAUMONDE) {
            tonnageMax = 2000;
        }
    }
    @Override
    public void emporterCargaison(int tonnage) throws DepassementTonnageException {
        int tonnageRestant = tonnageMax - tonnageActuel;
        if (tonnage > tonnageRestant) {
            int tonnageEnExces = tonnage-tonnageRestant;
            throw new DepassementTonnageException(tonnageEnExces);
        }
        tonnageActuel+=tonnage;
    }
}
