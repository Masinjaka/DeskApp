package services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputAdapter;

import interfaces.Personnels;

public class PersonneService {

    private Personnels personnels = new Personnels();
    private boolean actualiser = true;

    public PersonneService() {

        // Afficher l'information concernant la personne selectionnée
        personnels.getList().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {

                    //Récupérer tout les informations de la personne sélectionnée
                    String nom = personnels.getList().getSelectedValue().getNom();
                    String prenom = personnels.getList().getSelectedValue().getPrenom();
                    String photo = personnels.getList().getSelectedValue().getPhoto();

                    // Changer l'information à affichher sur le coté pour celui de la personne sélectionnée
                    personnels.getInfo().getnoms().setText(nom);
                    personnels.getInfo().getSchedule().setText(prenom);
                    personnels.getInfo().changePhoto(photo);
                }

            }

        });

        // Action du bouton ajouter
        personnels.getAdd().addMouseListener(new MouseInputAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // Afficher une fenêtre d'ajout
                AjouterService AJService = new AjouterService();
                AJService.setVisible(true);
            }
        });


        // Créer une boucle temporel qui actualise la liste de personnel 
        Timer reload = new Timer(1/3, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Actualisation
                if(actualiser){

                    // TODO: Recharger la liste de peronnel

                }

            }
            
        });
        reload.setRepeats(true);
        reload.setCoalesce(true);
        reload.start();
    }

    public Personnels getPersonnels() {
        return personnels;
    }

    public void setPersonnels(Personnels personnels) {
        this.personnels = personnels;
    }

}
