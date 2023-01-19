package interfaces;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.CreateTables;
import database.Database;
import database.Tables;
import services.LogInService;
import services.MenuServices;
<<<<<<< HEAD
=======
import tasks.DataModifiable;
import tasks.EveController;
>>>>>>> 8e0b34ae359feca02832b45905e602900e3cb939
import utilities.Colors;
import utilities.Fonts;

import javax.swing.Timer;

public class Template extends JFrame{
    
    JPanel container = (JPanel)this.getContentPane();

    private MenuServices menuServices = new MenuServices();

    // Data base
    private Database db = new Database();
<<<<<<< HEAD
    private CreateTables createTables ;
    public static Tables db_tables ;

    public static boolean autorizeLogin=false;

    //constructeur pour le Login
    public Template(int log){
        super("Login");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(new LogInService().getLogin().login());
        this.setSize(600,500);
        this.setMinimumSize(new Dimension(750,600));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        //Connect to database 
        this.db.ConnectBase();
        this.createTables=new CreateTables();
        db_tables = new Tables();
        Timer thread=new Timer(1,new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(autorizeLogin) {
                
                Template t=new Template();
				Template.this.dispose();
				((Timer)e.getSource()).stop();
			}
        }
		
	});
	thread.start();
	thread.setRepeats(true);
    }
=======
    private CreateTables createTables;
    public static Tables db_tables;
    public static EveController time_control;

    public static MenuServices menuServices;
>>>>>>> 8e0b34ae359feca02832b45905e602900e3cb939

    //Constructor
    public Template(){
        //dash

        //Setups

<<<<<<< HEAD
        this.setTitle("Smart teknolojia");
        this.setSize(1000,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
=======
        // ? Connecter à la base de donnée 
        this.db.ConnectBase();
        createTables = new CreateTables();
        db_tables = new Tables();
        menuServices = new MenuServices();
        time_control = new EveController();
>>>>>>> 8e0b34ae359feca02832b45905e602900e3cb939

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
