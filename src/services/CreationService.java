package services;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.event.MouseInputAdapter;

import com.formdev.flatlaf.ui.FlatLineBorder;

import diu.swe.habib.JPanelSlider.JPanelSlider;
import interfaces.Creation;
import interfaces.Login;
import interfaces.Template;
import utilities.Colors;
import utilities.OptionPanes;

public class CreationService {
    private Creation creation = new Creation();

    // Option pane
    private OptionPanes unknowPersonne = new OptionPanes(null, "smart", "Personnel introuvable",
            "Cette personne n'existe pas dans la liste", "img/alert.png", false);
    private OptionPanes passOption = new OptionPanes(null, "smart", "Mot de passe non identique",
            "Verifier votre mot de passe", "img/alert.png", false);
    private OptionPanes userNOption = new OptionPanes(null, "smart", "Username dèja utilisé",
            "Trouvez une autre username",
            "img/alert.png", false);
    private OptionPanes reponseOption = new OptionPanes(null, "smart", "Réponse vide ",
            "Vous devez répondre cette question", "img/alert.png", false);
    private OptionPanes doneOption = new OptionPanes(null, "smart", "Fini", "Creation compte effectuée",
            "img/reussit.png", false);
            
    // compterur pour le bouton suivant et retour
    private int countNext = 0;

    public CreationService() {
        // action de bouton next
        creation.getNext().addMouseListener(new MouseInputAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                checkChamps();
            }

        });

        // action de bouton retour
        creation.getRetour().addMouseListener(new MouseInputAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (countNext == 1) {
                    // pour le changement de
                    // langue----------------------------------------------------------
                    if (creation.getRetour().getText().equals("retour"))
                        creation.getRetour().setText("Log in");
                    else if (creation.getRetour().getText().equals("Miverina"))
                        creation.getRetour().setText("Hiditra");
                    // -----------------------------------------------------------------------------
                    creation.getSlider().nextPanel(1, creation.getCreation1(), JPanelSlider.left);
                    countNext--;
                } else if (countNext == 2) {
                    creation.getNext().setText("Suivant");
                    creation.getSlider().nextPanel(1, creation.getCreation2(), JPanelSlider.left);
                    countNext--;
                } else {
                    Login.slidePan.remove(1);
                }
            }

        });

        // remove red mard
        removeRedMark();

    }

    // Methode pour verification des champs et creation de compte
    private void checkChamps() {
        if (countNext == 0) {
            if (creation.getNomField().getText().equals("") ||
                    creation.getPrenomField().getText().equals("")) {
                redMark1();
            }
            // ------- verification personnel dans la base------------------
            else if (!isPersonnel(creation.getNomField().getText(), creation.getPrenomField().getText())) {
                creation.getSlider().nextPanel(1, creation.getCreation2(), JPanelSlider.right);

                // pour le changement de langue-------------------------------------------------
                if (creation.getRetour().getText().equals("Log in"))
                    creation.getRetour().setText("retour");
                else if (creation.getRetour().getText().equals("Hiditra"))
                    creation.getRetour().setText("Miverina");
                countNext++;
                // ---------------------------------------------------------------------------------

            } else {

                unknowPersonne.montrer();
            }

        } else if (countNext == 1) {
            if (creation.getField().getText().equals("")
                    || new String(creation.getPassField().getPassword()).equals("") ||
                    new String(creation.getConfirmField().getPassword()).equals("")) {
                redMark2();

                // ---verifie si l'username est déja utilisé par une autre
                // compte------------------
            } else if (!usernameUsed(creation.getField().getText())) {
                if (new String(creation.getPassField().getPassword())
                        .equals(new String(creation.getConfirmField().getPassword()))) {

                    // pour le changement de
                    // langue------------------------------------------------------
                    if (creation.getNext().getTextLabel().getText().equals("Suivant"))
                        creation.getNext().getTextLabel().setText("Créer");
                    else if (creation.getNext().getTextLabel().getText().equals("Manaraka"))
                        creation.getNext().getTextLabel().setText("Foronina");
                    // -----------------------------------------------------------------------------------------------------------

                    creation.getSlider().nextPanel(1, creation.getCreation3(), JPanelSlider.right);
                    countNext++;
                } else {

                    passOption.montrer();
                }
            } else {

                userNOption.montrer();
            }
        } else if (countNext == 2) {
            if (creation.getReponseField().getText().isEmpty()) {

                reponseOption.montrer();
            } else {
                try {
                    String password = new String(creation.getPassField().getPassword());
                    Template.db_tables.getUtilisateur().ajouter(creation.getNomField().getText(),
                            creation.getPrenomField().getText(),
                            creation.getField().getText(),
                            password,
                            creation.getQuestionsBox().getSelectedItem().toString(),
                            creation.getReponseField().getText());

                    doneOption.montrer();
                    Login.slidePan.remove(1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // redMark1
    public void redMark1() {
        if (creation.getNomField().getText().equals("")) {
            creation.getNomField().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Color.red, 3, 20));
        }
        if (creation.getPrenomField().getText().equals("")) {
            creation.getPrenomField().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Color.red, 3, 20));
        }
    }

    // redMark2
    public void redMark2() {
        if (creation.getField().getText().equals("")) {
            creation.getField().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Color.red, 3, 20));
        }
        if (new String(creation.getPassField().getPassword()).equals("")) {
            creation.getPassField().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Color.red, 3, 20));
        }
        if (new String(creation.getConfirmField().getPassword()).equals("")) {
            creation.getConfirmField().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Color.red, 3, 20));
        }
    }

    // remove redMark
    public void removeRedMark() {
        creation.getNomField().addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                creation.getNomField().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Colors.purple, 3, 20));
            }
        });
        creation.getPrenomField().addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                creation.getPrenomField().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Colors.purple, 3, 20));
            }
        });
        creation.getField().addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                creation.getField().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Colors.purple, 3, 20));
            }
        });
        creation.getPassField().addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                creation.getPassField().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Colors.purple, 3, 20));
            }
        });
        creation.getConfirmField().addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                creation.getConfirmField()
                        .setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Colors.purple, 3, 20));
            }
        });
    }

    // Methode pour verifier le nom et le prénom du personnel
    public boolean isPersonnel(String nom, String prenom) {
        boolean test = false;
        try {
            ResultSet res = Template.db_tables.getTablePersonnel().select();
            while (res.next()) {
                if (res.getString("Nom").equals(nom) && res.getString("Prenom").equals(prenom)) {
                    test = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return test;

    }

    // Methode pour verifier si l'username est déja utilisé
    public boolean usernameUsed(String username) {
        boolean result = false;
        try {
            ResultSet res = Template.db_tables.getUtilisateur().select();
            while (res.next()) {
                if (res.getString("UserName").equals(username)) {
                    result = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Creation getCreation() {
        return creation;
    }

    public void setCreation(Creation creation) {
        this.creation = creation;
    }

    public OptionPanes getPassOption() {
        return passOption;
    }

    public void setPassOption(OptionPanes passOption) {
        this.passOption = passOption;
    }

    public OptionPanes getUserNOption() {
        return userNOption;
    }

    public void setUserNOption(OptionPanes userNOption) {
        this.userNOption = userNOption;
    }

    public OptionPanes getUnknowPersonne() {
        return unknowPersonne;
    }

    public void setUnknowPersonne(OptionPanes unknowPersonne) {
        this.unknowPersonne = unknowPersonne;
    }

    public OptionPanes getReponseOption() {
        return reponseOption;
    }

    public void setReponseOption(OptionPanes reponseOption) {
        this.reponseOption = reponseOption;
    }

    public OptionPanes getDoneOption() {
        return doneOption;
    }

    public void setDoneOption(OptionPanes doneOption) {
        this.doneOption = doneOption;
    }

}
