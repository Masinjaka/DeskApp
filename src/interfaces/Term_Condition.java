package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import com.intellij.openapi.ui.VerticalFlowLayout;

import utilities.Colors;
import utilities.Fonts;
import utilities.Labels;
public class Term_Condition extends JPanel{
    public Term_Condition(){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(15,10,10,10));
        this.setOpaque(false);
        this.add(titre(),BorderLayout.NORTH);
        this.add(Condition(),BorderLayout.CENTER);
    }
    private JPanel titre(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titre = new JLabel("Termes et conditions");
        titre.setFont(new Font(Fonts.textFont,Font.BOLD,25));
        titre.setForeground(Colors.text);
        titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
        panel.add(titre);
        panel.setOpaque(false);

        return panel;

    }
     //Contenu du termes et conditions
     private JPanel Condition(){

        VerticalFlowLayout layout = new VerticalFlowLayout();
        layout.setHorizontalFill(true);

        // *********************** PANELS ************************

        
        JPanel panel = new JPanel();
        JScrollPane Scroll = new JScrollPane();
        JPanel pan = new JPanel();

        panel.setLayout(layout);
        panel.setOpaque(false);
//-----******************* LABELS ************-*--------

        Labels Mini_titre = new Labels("SMART TEKNOLOJIA", Fonts.textFont, Colors.purple, 20);

        JTextArea Term_condition = new JTextArea("7.1 Smart Teknolojia s'engage à prendre toute précaution raisonnable pour assurer la protection matérielle des données et des programmes que LE CLIENT lui aura confiés. \n7.2 La responsabilité de Smart Teknolojia ne sera pas engagé dans les cas ci-après :\n - détérioration de l'application du fait du CLIENT et/ou non-respect des conseils donnés. \n- mauvaise utilisation des serveurs et des logiciels par LE CLIENT ou par sa CLIENTELE.\n - destruction partielle ou totale des informations transmises ou stockées à la suite d'erreurs imputables directement ou indirectement au CLIENT.");
        Term_condition.setEditable(false);
        Term_condition.setBackground(Colors.backgrounds);

   
        Scroll.setViewportView(pan);
        pan.setBackground(Colors.backgrounds);
        pan.add(Term_condition);
        pan.setSize(500, 700);

        panel.add(Mini_titre);
        panel.add(Scroll);

        
        return panel;
    }
}
