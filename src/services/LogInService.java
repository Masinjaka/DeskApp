package services;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;

import com.formdev.flatlaf.ui.FlatLineBorder;

import diu.swe.habib.JPanelSlider.JPanelSlider;
import interfaces.Account;
import interfaces.Login;
import interfaces.Template;
import utilities.Colors;
import utilities.Login.showHidePasse;

public class LogInService {
    private Login login = new Login();
    private boolean testEyes = false;

    public LogInService() {
        // action de bouton Se connecter
        login.getBtnConnect().addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    connectingLangue();
                    verifierUtilisateur(login.getTxtUserName(), login.getTxtPass());

            }
        });

        // action bouton mot de passe oublié
        login.getLabForgotPass().addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login.slidePan.add(login.getPanForgotPass());
                Login.slidePan.nextPanel(1, login.getPanForgotPass(), JPanelSlider.right);
            }
        });

        // action bouton creation compte
        login.getLabCreer().addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login.slidePan.add(login.getPanelCreation());
                Login.slidePan.nextPanel(1, login.getPanelCreation(), JPanelSlider.right);
            }
        });
        // visible et non visible pass
        login.getImgVisible().addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (testEyes) {
                    showHidePasse.showPass(login.getTxtPass(), login.getImgVisible());
                    testEyes = false;
                } else if (!testEyes) {
                    showHidePasse.hidePass(login.getTxtPass(), login.getImgVisible());
                    testEyes = true;

                }
            }
        });

    }

    // *************************verification utilisateur dans la
    // base*************************
    public void verifierUtilisateur(JTextField userName, JPasswordField pass)  {
        
        if (userName.getText().equals("") || new String(pass.getPassword()).equals("")) {
            // pour le
            // language------------------------------------------------------------------------------
            checkLanguage();
            // ----------------------------------------------------------------------------------------------------------

            if (userName.getText().isEmpty()) {
                login.getUserNamePanel().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Color.red, 3, 20));
                login.getLabStatutUserName().setForeground(Color.red);
                login.getLabStatutUserName().setText("veuiller remplir");
            }
            if (new String(pass.getPassword()).isEmpty()) {
                login.getPassPanel().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Color.red, 3, 20));
                login.getLabStatutTxtPass().setForeground(Color.red);
                login.getLabStatutTxtPass().setText("veuiller remplir");
            }

        } else {
            ResultSet res = null;
            try {
                res = Template.db_tables.getUtilisateur().select();
                while (res.next()) {
                    if (userName.getText().equalsIgnoreCase(res.getString("UserName"))) {
                        // byte[] passEntered=new hash(pass.getText().toCharArray()).hasher();
                        String passEntered = new String(pass.getPassword());

                        if (res.getString("Mdp").equals(passEntered)) {
                            Account.fieldUsername.setText(login.getTxtUserName().getText());
                            System.out.println("you are logged in!!");
                            login.getStatut().setText("");
                            login.getPassPanel().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Colors.purple, 3, 20));
                        login.getUserNamePanel().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Colors.purple, 3, 20));
                            Template.autorizeLogin = true;
                            break;
                        } else {
                            login.getStatut().setText("Mot de passe incorrect");
                            login.getLabStatutTxtPass().setText("* Incorrect!!");
                            login.getLabStatutTxtPass().setForeground(Color.red);
                            login.getPassPanel().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Color.red, 3, 20));
                            break;
                        }
                    } else {
                        login.getLabStatutUserName().setForeground(Color.red);
                        login.getLabStatutTxtPass().setForeground(Color.red);
                        login.getStatut().setText("Mot de pass ou username incorrect");
                        login.getPassPanel().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Color.red, 3, 20));
                        login.getUserNamePanel().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Color.red, 3, 20));
                    }
                }

                if(!Template.autorizeLogin)
                    checkLanguage();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
    }

    public void checkLanguage() {
        System.out.println("check:" + login.getBtnConnect().getTextLabel().getText());

        if (login.getBtnConnect().getTextLabel().getText().equals("connexion..."))
            login.getBtnConnect().getTextLabel().setText("Se connecter");
        else
            login.getBtnConnect().getTextLabel().setText("Hiditra");
    }

    public void connectingLangue() {
        // por le language------------------------------------------------------------
        if (login.getBtnConnect().getTextLabel().getText().equals("Se connecter"))
            login.getBtnConnect().getTextLabel().setText("connexion...");
        else
            login.getBtnConnect().getTextLabel().setText("Fidirana...");
        // ------------------------------------------------------------------------
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

}
