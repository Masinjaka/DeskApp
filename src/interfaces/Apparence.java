package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

import com.formdev.flatlaf.ui.FlatLineBorder;
import com.intellij.openapi.ui.VerticalFlowLayout;

import utilities.AsideLayout;
import utilities.Colors;
import utilities.Fonts;
import utilities.Labels;
import utilities.Sary;
import java.util.Locale;
import java.util.ResourceBundle;

public class Apparence extends JPanel{
    private Locale currentLocale = Locale.FRANCE;
    private ResourceBundle messages;
    JLabel titre;
    Labels language;
    Labels theme;
    Labels taille;
//    Menus men = Template.menuServices.getMenu();
    public Apparence(){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(15,10,10,10));
        this.setOpaque(false);
        this.add(titre(),BorderLayout.NORTH);
        this.add(settings(),BorderLayout.CENTER);
    }

    // Titre du parametre
    private JPanel titre(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titre = new JLabel("Apparence");
        titre.setFont(new Font(Fonts.textFont,Font.BOLD,25));
        titre.setForeground(Colors.text);
        titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
        panel.add(titre);
        panel.setOpaque(false);

        return panel;
    }
    
    //Contenu du parametre
    private JPanel settings(){

        VerticalFlowLayout layout = new VerticalFlowLayout();
        layout.setHorizontalFill(true);

        // *********************** PANELS ************************

        JPanel panel = new JPanel();
        panel.setLayout(layout);

        panel.setOpaque(false);

        //-----******************* LABELS ************-*--------

        language = new Labels("Langage", Fonts.textFont, Colors.text, 15);
        theme = new Labels("Thème", Fonts.textFont, Colors.text, 15);
        taille= new Labels("Taille de police", Fonts.textFont, Colors.text, 15);
        
        // Créer un JCombobox pour le choix de langue
        JComboBox<String> box = new JComboBox<>();
        box.addItem("Français");
        box.addItem("Malagasy");
        //box.addItem("Anglais");
        box.setBorder((Border) new FlatLineBorder(new Insets(8,10,8,10), Colors.purple,3,20));
        //messages = ResourceBundle.getBundle("resources/messages");
        box.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = box.getSelectedIndex();
                if(selectedIndex == 0){
                    currentLocale = Locale.FRANCE;
                }else{
                    currentLocale = new Locale("mg","MG");
                }
                messages = ResourceBundle.getBundle("resources/messages", currentLocale);
                updateInterface();

                
            }

        });



        // Créer un toggle pour le choix de theme
        JToggleButton toggle = new JToggleButton();
        toggle.setText("LIGHT");
        toggle.setSelectedIcon(new ImageIcon(new Sary().Resize("img/on.png", 15, 15)));
        toggle.setIcon(new ImageIcon(new Sary().Resize("img/off.png", 15, 15)));
        toggle.setBorder((Border) new FlatLineBorder(new Insets(8,42,8,10), Colors.purple,3,20));

        // Créer un JCombo pour le choix de taille de police
        JComboBox<String> boxtaille = new JComboBox<>();
        boxtaille.addItem("15%");
        boxtaille.addItem("50%");
        boxtaille.addItem("75%");
        boxtaille.setBorder((Border) new FlatLineBorder(new Insets(6,38,6,10), Colors.purple,3,20));

        // Arranger tout les élements en place
        AsideLayout langLayout = new AsideLayout(language, box);
        AsideLayout themeLayout = new AsideLayout(theme, toggle);
        AsideLayout tailleLayout = new AsideLayout(taille, boxtaille);


        panel.add(langLayout);panel.add(themeLayout);panel.add(tailleLayout);



        return panel;
    }
    private void updateInterface(){
             titre.setText(messages.getString("titre"));
            language.setText(messages.getString("lang"));       
            taille.setText(messages.getString("taille"));
            theme.setText(messages.getString("them"));
          //  men.dash.getMenu().setText(messages.getString("tab"));
           // Template.menuServices.getMenu().dash.getMenu().setText(messages.getString("tab"));
    
           Menus.dash.getMenu().setText(messages.getString("tab"));
           Menus.debut.getMenu().setText(messages.getString("deb"));
           Menus.fin.getMenu().setText(messages.getString("fin"));
           Menus.list.getMenu().setText(messages.getString("pers"));
           Menus.setting.getMenu().setText(messages.getString("param"));

          Dashboard.welcomeLabel.setText(messages.getString("tonga"));
          Dashboard.profile.getNom().setText(messages.getString("user"));
          Dashboard.profile.getPost().setText(messages.getString("occup"));
          Historics.title.setText(messages.getString("histo"));

        
        
    
    }
    
}
