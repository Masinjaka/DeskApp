package utilities.peronnel;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.formdev.flatlaf.ui.FlatLineBorder;

import utilities.Colors;
import utilities.Fonts;
import utilities.ImageProfile;
import utilities.Sary;

public class WorkerInfo extends JPanel {

    private String photo,nom,prenom;
    private JLabel noms,schedule,icon;
    private JLabel remove,edit;

    public WorkerInfo(String photo,String nom,String prenom){

        this.photo = photo;
        this.nom = nom;
        this.prenom = prenom;
        
        this.setBackground(Colors.text);
        this.setBorder(new FlatLineBorder(new Insets(5,0,5,0), Colors.stroke, 0, 20));
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.add(profile());
    }

    private JPanel profile(){

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel iconPanel = new JPanel();
        iconPanel.setOpaque(false);
        icon = new JLabel(new ImageIcon(new ImageProfile().ResizeCercle("img/workers/"+this.photo, 100,100, Colors.stroke)));
        
        JPanel nomsPanel = new JPanel();
        nomsPanel.setLayout(new BoxLayout(nomsPanel,BoxLayout.Y_AXIS));
        JPanel nomPanel = new JPanel();JPanel schePanel = new JPanel();
        nomPanel.setOpaque(false);schePanel.setOpaque(false);
        this.noms  = new JLabel(this.nom);
        this.schedule = new JLabel(this.prenom);

        //Customization
        schedule.setFont(new Font(Fonts.textFont,Font.BOLD,15));
        schedule.setForeground(Colors.backgrounds);
        noms.setFont(new Font(Fonts.textFont,Font.BOLD,15));
        noms.setForeground(Colors.backgrounds);
        panel.setOpaque(false);nomsPanel.setOpaque(false);

        //Laying out elements
        nomPanel.add(noms);schePanel.add(schedule);

        nomsPanel.add(nomPanel);nomsPanel.add(schePanel);
        iconPanel.add(icon);

        panel.add(actions());
        panel.add(iconPanel);
        panel.add(nomsPanel);

        return panel;
    }
    private JPanel actions(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setOpaque(false);

        remove = new JLabel(new ImageIcon(new Sary().Resize("img/remove.png", 30, 30)));
        edit = new JLabel(new ImageIcon(new Sary().Resize("img/edit.png", 30, 30)));
        
        remove.setToolTipText("Retirer de la liste des peronnels");
        edit.setToolTipText("Modifier");

        //remove.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        //edit.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        panel.add(edit);panel.add(remove);
        return panel;
    }

    public void changePhoto(String nom_photo){
        icon.setIcon(new ImageIcon(new ImageProfile().ResizeCercle("img/workers/"+nom_photo, 100, 100, Colors.stroke)));
    }
    

    public JLabel getnoms() {
        return this.noms;
    }

    public void setnoms(JLabel noms) {
        this.noms = noms;
    }

    public JLabel getSchedule() {
        return schedule;
    }

    public void setSchedule(JLabel schedule) {
        this.schedule = schedule;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    
    
}
