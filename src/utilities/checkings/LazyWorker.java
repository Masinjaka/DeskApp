package utilities.checkings;

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
import utilities.ImageProfile;

public class LazyWorker extends JPanel{
    
    private String icon,name,missing;

    public LazyWorker(String icon, String name, String missing) {
        this.icon = icon;
        this.name = name;
        this.missing = missing;

        this.setBackground(Colors.backgrounds);
        this.setBorder(new FlatLineBorder(new Insets(5,0,0,0), getBackground(), 0, 20));
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.add(profile());
    }

    private JPanel profile(){

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel icon = new JLabel(new ImageIcon(new ImageProfile().ResizeCercle("img/workers/"+this.icon, 40, 40, Colors.purple)));
        
        JPanel namePanel = new JPanel(new VerticalFlowLayout());
        JLabel name  = new JLabel(this.name);
        JLabel skipped = new JLabel("n'a pas enregistré son "+this.missing);

        //Customization
        skipped.setFont(new Font("Century Gothic",Font.BOLD,13));
        skipped.setForeground(Colors.text);
        name.setFont(new Font("Century Gothic",Font.BOLD,13));
        name.setForeground(Colors.text);
        panel.setOpaque(false);namePanel.setOpaque(false);

        //Laying out elements
        namePanel.add(name);namePanel.add(skipped);

        panel.add(icon);
        panel.add(namePanel);

        return panel;

    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork_time() {
        return missing;
    }

    public void setWork_time(String missing) {
        this.missing = missing;
    }
}
