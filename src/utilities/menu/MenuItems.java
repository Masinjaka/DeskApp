package utilities.menu;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.formdev.flatlaf.ui.FlatLineBorder;

import utilities.Colors;
import utilities.Fonts;
import utilities.Sary;

public class MenuItems extends JPanel {

    private JLabel icon = new JLabel();
    private JLabel menu = new JLabel();
    boolean activated = false;
    public static boolean remove = true;
    boolean selfSelection = false;

    // Constructor
    public MenuItems(String icon, String menuTitle) {

        this.setBorder(new FlatLineBorder(new Insets(6, 8, 5, 8), Colors.stroke, 0, 20));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Colors.backgrounds);

        this.icon.setIcon(new ImageIcon(new Sary().Resize("img/" + icon + ".png", 15, 15)));
        this.menu.setText(menuTitle);
        this.menu.setFont(new Font(Fonts.textFont, Font.BOLD, 15));
        this.menu.setForeground(Colors.grey);
        this.menu.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        this.add(this.icon);
        this.add(Box.createHorizontalStrut(7));
        this.add(this.menu);

    }

    // set the menu button active
    public void setActive(boolean active) {
        if (active == true) {
            setBackground(Colors.purple);
            menu.setForeground(Colors.backgrounds);
            //this.setBorder(new FlatLineBorder(new Insets(6, 8, 5, 8), Colors.light_stroke, 1, 20));
            activated = true;
        } else {
            //this.setBorder(new FlatLineBorder(new Insets(6, 8, 5, 8), Colors.light_stroke, 0, 20));
            setBackground(Colors.backgrounds);
            menu.setForeground(Colors.grey);
            activated = false;
        }
    }

    // check if the menu button is active
    public boolean isActive() {
        if (activated) {
            return true;
        } else {
            return false;
        }
    }
}
