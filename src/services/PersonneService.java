package services;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import interfaces.Personnels;

public class PersonneService {
    private Personnels personnels = new Personnels();

    public PersonneService() {

        personnels.getList().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {

                    String nom = personnels.getList().getSelectedValue().getNom();
                    String prenom = personnels.getList().getSelectedValue().getPrenom();
                    String photo = personnels.getList().getSelectedValue().getPhoto();

                    personnels.getInfo().getnoms().setText(nom);
                    personnels.getInfo().getSchedule().setText(prenom);
                    personnels.getInfo().changePhoto(photo);
                }

            }

        });

    }

    public Personnels getPersonnels() {
        return personnels;
    }

    public void setPersonnels(Personnels personnels) {
        this.personnels = personnels;
    }

}
