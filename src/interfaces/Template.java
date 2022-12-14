package interfaces;


import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.CreateTables;
import database.Database;
import database.Tables;
import services.MenuServices;
import utilities.Colors;
import utilities.Fonts;
import utilities.menu.MenuItems;
import utilities.menu.UserProfile;

public class Template extends JFrame{
    
    JPanel container = (JPanel)this.getContentPane();
    
    MenuItems dash,debut,fin,list,setting;
    UserProfile profile = new UserProfile("user", "Username", "Occupation");
    //Dashboard dashboard = new Dashboard();
    private MenuServices menuServices = new MenuServices();

    // Data base
    private Database db=new Database();
    private CreateTables createTables;
    private Tables tables;

    //Constructor
    public Template(){
        //instance de data base
        db.ConnectBase();
        createTables=new CreateTables();
        tables=new Tables();
        
        //dash

        //Setups

        this.setTitle("Smart teknolojia");
        this.setSize(1000,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        this.add(menuServices.getMenu(),BorderLayout.WEST);
        this.add(menuServices.getDashboard(),BorderLayout.CENTER);
        this.add(footer(),BorderLayout.SOUTH);

        this.setVisible(true);
         
    }
    //footer
    public JPanel footer(){
        JPanel panel = new JPanel();
        JLabel copyright = new JLabel("Smart'Ora v0.1 | Copyright Smart tek 2022 | tout droit réservé");
        copyright.setFont(new Font(Fonts.textFont,Font.BOLD,12));
        copyright.setForeground(Colors.text);

        panel.add(copyright);
        return panel;
    }

}
