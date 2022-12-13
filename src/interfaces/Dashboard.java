package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.formdev.flatlaf.ui.FlatLineBorder;

import services.ClockInService;
import services.ClockOutService;
import services.HistoricService;
import services.ParametreService;
import services.PersonneService;
import utilities.Colors;
import utilities.menu.UserProfile;
public class Dashboard extends JPanel {

    Color backgroundColor = new Color(248, 249, 250);
    Color textColor = new Color(52, 58, 64);
    
    private PersonneService personneService = new PersonneService();
    private HistoricService historicService = new HistoricService();
    private ClockInService clockInService = new ClockInService();
    private ClockOutService clockOutService = new ClockOutService();
    private ParametreService parametreService = new ParametreService();


    private JLabel welcomeLabel;
    private JPanel placeholder;
    UserProfile profile = new UserProfile("user", "Username", "Occupation");

    public Dashboard(){

        placeholder = historicService.getHistorics();

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        this.add(welcomeBar(),BorderLayout.NORTH);
        this.add(placeholder,BorderLayout.CENTER);
        //this.add(personneService.getPersonnels(),BorderLayout.CENTER);
    }

    //TOp bar
    public JPanel welcomeBar(){

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setBorder(new FlatLineBorder(new Insets(0,10,0,10), Colors.stroke,1,20));

        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        welcomePanel.setOpaque(false);
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        searchPanel.setOpaque(false);

<<<<<<< HEAD
        welcomeLabel = new JLabel("Tongasoa eto amin'ny dezaka be");
=======
        welcomeLabel = new JLabel("Tongasoa eto ianao");
>>>>>>> 1f8a1ebe3ba668cb8837829b9382f952296dddcd
        welcomeLabel.setFont(new Font("Arial",Font.BOLD,30));
        welcomeLabel.setForeground(textColor);

        welcomePanel.add(welcomeLabel);

        JButton search = new JButton("Rechercher");
        search.setPreferredSize(new Dimension(100,30));
        search.setBackground(new Color(138, 60, 183));
        search.setForeground(Color.white);
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(150,30));

        searchPanel.add(profile);//searchPanel.add(search);

        panel.add(welcomePanel);panel.add(searchPanel);

        return panel;
    }

    //Adding the menu panel to the dashboard
    public void load(JPanel replacement){
        this.remove(placeholder);
        placeholder = replacement;
        this.add(placeholder,BorderLayout.CENTER);
        this.validate();
        this.repaint();
    }

    public PersonneService getPersonneService() {
        return personneService;
    }

    public void setPersonneService(PersonneService personneService) {
        this.personneService = personneService;
    }

    public HistoricService getHistoricService() {
        return historicService;
    }

    public void setHistoricService(HistoricService historicService) {
        this.historicService = historicService;
    }

    public JLabel getWelcomeLabel() {
        return welcomeLabel;
    }

    public void setWelcomeLabel(JLabel welcomeLabel) {
        this.welcomeLabel = welcomeLabel;
    }

    public ClockInService getClockInService() {
        return clockInService;
    }

    public void setClockInService(ClockInService clockInService) {
        this.clockInService = clockInService;
    }

    public ClockOutService getClockOutService() {
        return clockOutService;
    }

    public void setClockOutService(ClockOutService clockOutService) {
        this.clockOutService = clockOutService;
    }

    public ParametreService getParametreService() {
        return parametreService;
    }

    public void setParametreService(ParametreService parametreService) {
        this.parametreService = parametreService;
    }
    
    
    
}
