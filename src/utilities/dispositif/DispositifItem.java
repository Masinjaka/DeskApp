package utilities.dispositif;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

import com.formdev.flatlaf.ui.FlatLineBorder;

import utilities.Colors;
import utilities.Fonts;

public class DispositifItem extends JPanel {

    private String text;

    public DispositifItem(String text){
        this.text = text;
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setBorder(new FlatLineBorder(new Insets(8,8,8,8),Colors.stroke,1,20));
        
        JPanel textRFIDPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel switchRFIDPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel labelRFID = new JLabel(this.text);
        JCheckBox checkBox = new JCheckBox();

        
        labelRFID.setForeground(Colors.text);
        labelRFID.setFont(new Font(Fonts.textFont,Font.BOLD,15));
        
        textRFIDPanel.add(labelRFID);
        switchRFIDPanel.add(checkBox);

        this.add(textRFIDPanel);this.add(switchRFIDPanel);
    }
}