package services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import interfaces.Apparence;
import interfaces.Template;
import utilities.Labels;

public class ApparenceService {
    private ResourceBundle messages;
    private Apparence apparence=new Apparence();
    private Locale currentLocale = Locale.FRANCE;
    
    public ApparenceService(){
        // -------------------------changement de langue------------------------------------
       apparence.getBox().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = apparence.getBox().getSelectedIndex();
                if(selectedIndex == 0){
                    currentLocale = Locale.FRANCE;
                }else{
                    currentLocale = new Locale("mg","MG");
                }
                messages = ResourceBundle.getBundle("resources/messages", currentLocale);
                updateInterfaceLangue();
                
            }

        });

        // -------------------------changement de taille------------------------------------
        apparence.getBoxtaille().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = apparence.getBoxtaille().getSelectedIndex();
                if(selectedIndex==0){
                    updateInterfacePolice(50);
                }
                else if(selectedIndex==1){
                    updateInterfacePolice(75);
                }
                else{
                    updateInterfacePolice(100);
                }
                
            }

        });
    }

    // Methode update langue
    private void updateInterfaceLangue(){
        apparence.titre.setText(messages.getString("titre"));
        apparence.language.setText(messages.getString("lang"));
        apparence.taille.setText(messages.getString("taille"));
        apparence.theme.setText(messages.getString("them"));

        Template.menuServices.getMenu().dash.getMenu().setText(messages.getString("tab"));
        Template.menuServices.getMenu().debut.getMenu().setText(messages.getString("deb"));
        Template.menuServices.getMenu().fin.getMenu().setText(messages.getString("fin"));
        Template.menuServices.getMenu().list.getMenu().setText(messages.getString("pers"));
        Template.menuServices.getMenu().setting.getMenu().setText(messages.getString("param"));
        
        Template.menuServices.getDashboard().profile.getNom().setText(messages.getString("user"));
        Template.menuServices.getDashboard().profile.getPost().setText(messages.getString("post"));
        Template.menuServices.getDashboard().getWelcomeLabel().setText(messages.getString("tonga"));

        Template.menuServices.getDashboard().getParametreService().getParametre().menuApparence.getMenu().setText(messages.getString("titre"));
        Template.menuServices.getDashboard().getParametreService().getParametre().menuScan.getMenu().setText(messages.getString("scan_bag"));
        Template.menuServices.getDashboard().getParametreService().getParametre().menuCompte.getMenu().setText(messages.getString("compte"));
        Template.menuServices.getDashboard().getParametreService().getParametre().menuExporter.getMenu().setText(messages.getString("export"));
        Template.menuServices.getDashboard().getParametreService().getParametre().menuApropo.getMenu().setText(messages.getString("propos"));
        Template.menuServices.getDashboard().getParametreService().getParametre().menuTerm_cond.getMenu().setText(messages.getString("term"));

        // pour le welcome label
        Template.menuServices.getDashboard().getWelcomeLabel().setText(messages.getString("param"));

        Template.menuServices.getDashboard().getParametreService().getParametre().getAccountService().getAccount().getUsernameLabel().setText(messages.getString("username"));
        Template.menuServices.getDashboard().getParametreService().getParametre().getAccountService().getAccount().getChangePass().setText(messages.getString("changePass"));
        Template.menuServices.getDashboard().getParametreService().getParametre().getAccountService().getAccount().getChangeSQ().setText(messages.getString("changeQs"));
        Template.menuServices.getDashboard().getParametreService().getParametre().getAccountService().getAccount().getChangeCompte().setText(messages.getString("changeCompte"));

        //historique
        Template.menuServices.getDashboard().getHistoricService().getHistorics().getTitle().setText(messages.getString("histo"));
        Template.menuServices.getDashboard().getHistoricService().getHistorics().getDeviceLabel().setText(messages.getString("dispo"));
        //scanner Rfid
        Template.menuServices.getDashboard().getScannerRFIDService().getScanner().getPort().setText(messages.getString("choisiPort"));
        Template.menuServices.getDashboard().getScannerRFIDService().getScanner().getPortSuite().setText(messages.getString("moduleList"));
    }
    //Methode update police
    public void updateInterfacePolice(int pourcentage){
        apparence.titre.changeFont(pourcentage);
        apparence.language.changeFont(pourcentage);
        apparence.taille.changeFont(pourcentage);
        apparence.theme.changeFont(pourcentage);

        Template.menuServices.getMenu().dash.changeFont(pourcentage);
        Template.menuServices.getMenu().debut.changeFont(pourcentage);
        Template.menuServices.getMenu().fin.changeFont(pourcentage);
        Template.menuServices.getMenu().list.changeFont(pourcentage);
        Template.menuServices.getMenu().setting.changeFont(pourcentage);

        Template.menuServices.getDashboard().profile.changeFont(pourcentage);
        Template.menuServices.getDashboard().profile.changeFont(pourcentage);

        Template.menuServices.getDashboard().getParametreService().getParametre().menuApparence.changeFont(pourcentage);
        Template.menuServices.getDashboard().getParametreService().getParametre().menuScan.changeFont(pourcentage);
        Template.menuServices.getDashboard().getParametreService().getParametre().menuCompte.changeFont(pourcentage);
        Template.menuServices.getDashboard().getParametreService().getParametre().menuExporter.changeFont(pourcentage);
        Template.menuServices.getDashboard().getParametreService().getParametre().menuApropo.changeFont(pourcentage);
        Template.menuServices.getDashboard().getParametreService().getParametre().menuTerm_cond.changeFont(pourcentage);

        ((Labels) Template.menuServices.getDashboard().getWelcomeLabel()).changeFont(pourcentage);

        
        Template.menuServices.getDashboard().getParametreService().getParametre().getAccountService().getAccount().getUsernameLabel().changeFont(pourcentage);
        Template.menuServices.getDashboard().getParametreService().getParametre().getAccountService().getAccount().getChangePass().changeFont(pourcentage);
        Template.menuServices.getDashboard().getParametreService().getParametre().getAccountService().getAccount().getChangeSQ().changeFont(pourcentage);
        Template.menuServices.getDashboard().getParametreService().getParametre().getAccountService().getAccount().getChangeCompte().changeFont(pourcentage);

        //historique
        Template.menuServices.getDashboard().getHistoricService().getHistorics().getTitle().changeFont(pourcentage);
        Template.menuServices.getDashboard().getHistoricService().getHistorics().getDeviceLabel().changeFont(pourcentage);

        //scanner Rfid
        Template.menuServices.getDashboard().getScannerRFIDService().getScanner().getPort().changeFont(pourcentage);
        Template.menuServices.getDashboard().getScannerRFIDService().getScanner().getPortSuite().changeFont(pourcentage);

    }

    public Apparence getApparence() {
        return apparence;
    }

    public void setApparence(Apparence apparence) {
        this.apparence = apparence;
    }
    
}