package utilities.menu;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.intellij.openapi.ui.VerticalFlowLayout;

import utilities.Colors;
import utilities.Sary;

public class UserProfile extends JPanel {
    
    private String imageIcon;
    private String name;
    private String poste;
    
    public UserProfile(String imageIcon, String name, String poste) {
        this.imageIcon = imageIcon;
        this.name = name;
        this.poste = poste;

        this.profileUI();
    }

    private void profileUI(){
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Creating elements
        JLabel icon = new JLabel(new ImageIcon(new Sary().Resize("img/profile/"+this.imageIcon+".png", 30,30)));
        JPanel stack = new JPanel(new VerticalFlowLayout());
        JLabel nom = new JLabel(this.name);
        JLabel post = new JLabel(this.poste);

        //Putting in place
        stack.add(nom);stack.add(post);
        this.add(icon);this.add(stack);

        //Customization
        //this.setBorder(BorderFactory.createEmptyBorder(10,10,20,10));
        stack.setOpaque(false);
        this.setOpaque(false);
        nom.setFont(new Font("Arial",Font.BOLD,15));
        nom.setForeground(Colors.text);
    }


    public String getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(String imageIcon) {
        this.imageIcon = imageIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    

}
