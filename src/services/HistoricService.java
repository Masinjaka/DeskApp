package services;

import java.time.LocalTime;

import interfaces.Historics;
import tasks.Verifiable;

public class HistoricService implements Verifiable{

    private Historics historics = new Historics();
    private String carte = "";
    LocalTime time = LocalTime.now();

    public HistoricService(){

        // ? Charger la liste
        load();

        // ? Actualiser la liste
        actualiser();
        /*
         * Ecrit ici une boucle de type Timer qui actualise l'historique tout les 1/3 de séconde 
         * et qui affiche une nouvelle personne uniquement s'il la nouvelle carte est dans la base de donnée 
         * 
         */
    }
    private void load(){

        //1- Maka donnée avy any @ table historique 
        //2- Afficher anazy eo am liste 
    }

    public void actualiser(){

        // 1- Tsy vide le badge && tsy manao ajout 
        // 2- Vérifier oe misy ao am base
        /*  3- Collecter donnée {
            nom et prenom
            tranche horraire 
            heure de pointage
        }*/
        //3- Séparer niditra et nivoaka 
        //4- Enregistrer any am base ny historique sy ny niditra/nivoaka 

    }

    public Historics getHistorics() {
        return historics;
    }

    public void setHistorics(Historics historics) {
        this.historics = historics;
    }

    @Override
    public boolean existe() {
        // Carte misy ao @ table personne ? 
        return false;
    }
    
}
