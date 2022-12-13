package utilities.peronnel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.formdev.flatlaf.ui.FlatLineBorder;
import com.intellij.openapi.ui.VerticalFlowLayout;

import utilities.Colors;
import utilities.Fonts;
import utilities.ImageProfile;

public class WorkerCard extends JPanel {

    private String photo,nom,prenom,poste;
    private JLabel name,schedule;
    

    public WorkerCard(String photo,String nom,String prenom,String poste){

        this.photo = photo;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        
        this.setBackground(Colors.backgrounds);
        this.setBorder(new FlatLineBorder(new Insets(5,0,5,0), Colors.stroke, 0, 20));
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.add(profile());
    }

    private JPanel profile(){

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel icon = new JLabel(new ImageIcon(new ImageProfile().ResizeCercle("img/workers/"+this.photo, 50, 50, Colors.stroke)));
        
        JPanel namePanel = new JPanel(new VerticalFlowLayout());
        this.name  = new JLabel(this.nom +" "+this.prenom);
        this.schedule = new JLabel(this.poste);

        //Customization
        schedule.setFont(new Font(Fonts.textFont,Font.BOLD,11));
        schedule.setForeground(Color.gray);
        name.setFont(new Font(Fonts.textFont,Font.BOLD,15));
        name.setForeground(Colors.text);
        panel.setOpaque(false);namePanel.setOpaque(false);

        //Laying out elements
        namePanel.add(name);namePanel.add(schedule);

        panel.add(icon);
        panel.add(namePanel);

        return panel;
    }

    


    public void setActive(boolean state){
        if(state){

            this.setBackground(Colors.purple);
            this.name.setForeground(Colors.backgrounds);
            this.schedule.setForeground(Colors.backgrounds);


        }else{

            this.setBackground(Colors.backgrounds);
            this.name.setForeground(Colors.text);
            this.schedule.setForeground(Color.gray);

        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    
    
}
