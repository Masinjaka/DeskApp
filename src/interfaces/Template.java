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
import tasks.DataModifiable;
import tasks.EveController;
import utilities.Colors;
import utilities.Fonts;

public class Template extends JFrame{
    
    JPanel container = (JPanel)this.getContentPane();

    // Data base
    private Database db = new Database();
    private CreateTables createTables;
    public static Tables db_tables;
    public static EveController time_control;

    private MenuServices menuServices;

    //Constructor
    public Template(){

        DataModifiable.frame = this;

        // ? Connecter à la base de donnée 
        this.db.ConnectBase();
        createTables = new CreateTables();
        db_tables = new Tables();
        menuServices = new MenuServices();
        time_control = new EveController();

        // ? initialiser UI
        initialiserUI();

        
         
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

    // paramètre UI
    private void initialiserUI(){

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


}
