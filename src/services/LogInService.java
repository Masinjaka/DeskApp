package services;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.security.NoSuchAlgorithmException;
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
import utilities.Buttons;
import utilities.Login.showHidePasse;

public class LogInService {
    private Login login = new Login();
    private boolean testEyes = false;

    public LogInService() {
        // action de bouton Se connecter
        login.getBtnConnect().addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              try {
                    verifierUtilisateur(login.getTxtUserName(), login.getTxtPass());
                } catch (NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                }

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

    // *************************verification utilisateur dans la base*************************
    public  void verifierUtilisateur(JTextField userName,JPasswordField pass) throws NoSuchAlgorithmException {
			if(userName.getText().equals("")||new String(pass.getPassword()).equals("")) {
                 if(userName.getText().equals("")) {
                    login.getUserNamePanel().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Color.red, 3, 20));
                    login.getLabStatutUserName().setForeground(Color.red);
                    login.getLabStatutUserName().setText("veuiller remplir");
                    }
                 if(new String(pass.getPassword()).equals("")){
                    login.getPassPanel().setBorder(new FlatLineBorder(new Insets(2, 10, 2, 10), Color.red, 3, 20));
                    login.getLabStatutTxtPass().setForeground(Color.red);
                    login.getLabStatutTxtPass().setText("veuiller remplir");
                }
                    
			}else {
	    	 ResultSet res=null;
	   			try {
	   			  res=Template.db_tables.getUtilisateur().select();
	   				while(res.next()) {
                            if(userName.getText().equalsIgnoreCase(res.getString("UserName"))) {
                               // byte[] passEntered=new hash(pass.getText().toCharArray()).hasher();
                                    String passEntered=new String(pass.getPassword());

                                if(res.getString("Mdp").equals(passEntered)) {
                                   Account.fieldUsername.setText(login.getTxtUserName().getText());
                                    System.out.println("you are logged in!!");
                                    login.getStatut().setText("");
                                    Template.autorizeLogin=true;
                                    break;
                                }
                                else {
                                    
                                    login.getStatut().setText("Mot de passe incorrect");
                                    login.getLabStatutTxtPass().setText("* Incorrect!!");
                                    login.getLabStatutTxtPass().setForeground(Color.red);
                                    break;
                                }
                            }
                           else{
                                login.getLabStatutUserName().setForeground(Color.red);
                                login.getLabStatutTxtPass().setForeground(Color.red);
                                login.getStatut().setText("Mot de pass ou username incorrect");
                            }
	   				 }
	   			
	   			} catch (SQLException e1) {
	   				e1.printStackTrace();
	   			}

             }
            }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

}
