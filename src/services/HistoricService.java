package services;

import interfaces.Historics;

public class HistoricService {

    private Historics historics = new Historics();

    public HistoricService(){
        /*
         * Ecrit ici une boucle de type Timer qui actualise l'historique tout les 1/3 de séconde 
         * et qui affiche une nouvelle personne uniquement s'il la nouvelle carte est dans la base de donnée 
         * 
         */
    }

    public Historics getHistorics() {
        return historics;
    }

    public void setHistorics(Historics historics) {
        this.historics = historics;
    }
    
    
}
