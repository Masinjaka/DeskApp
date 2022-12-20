package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
// import javax.swing.JScrollPane;
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
         panel.setLayout(layout);

        panel.setOpaque(false);
//-----******************* LABELS ************-*--------


        Labels Mini_titre = new Labels("terme et condition  no eto", Fonts.textFont, Colors.purple, 20);
        JTextArea Term_condition = new JTextArea("terme et condition ooooooooooooo");
        Term_condition.setEditable(false);

   
        panel.setBackground(Colors.blue);
        panel.add(Mini_titre); 
        panel.add(Term_condition);

        
        return panel;
    }
}
