package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.event.MouseInputAdapter;

import com.fazecast.jSerialComm.SerialPort;
import com.formdev.flatlaf.ui.FlatLineBorder;
import com.intellij.openapi.ui.VerticalFlowLayout;

import diu.swe.habib.JPanelSlider.JPanelSlider;
import utilities.Buttons;
import utilities.Colors;
import utilities.Fonts;
import utilities.Labels;
import utilities.Sary;

public class ScannerRFID extends JPanel{

    private JPanelSlider slider;
    private JPanel networkPanel = new JPanel();
    private JPanel serialPortPanel = new JPanel();
    private JPanel linkModule = new JPanel();
    private JLabel steps = new JLabel();
    JComboBox<String> comPorts;
    private SerialPort[] serialPorts;
    private SerialPort serialPort;
    private boolean scanning = true;

    public ScannerRFID(){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(15,10,10,10));
        this.setOpaque(false);

        //Setup in place
        this.add(titre(),BorderLayout.NORTH);
        this.add(settings(),BorderLayout.CENTER);
        this.add(steps(),BorderLayout.SOUTH);
    }

    public void connectToPort(){
        String selectedPort = (String) comPorts.getSelectedItem();
        serialPort = SerialPort.getCommPort(selectedPort);
        serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        if(serialPort.openPort()){
            JOptionPane.showMessageDialog(null, "Connected to "+selectedPort);
            scanning = false;
        }else{
            JOptionPane.showMessageDialog(null, "Failed to connect to "+selectedPort);
        }
    }

    public void port_scanning(){
        SwingWorker worker = new SwingWorker<Void,Void>(){

            @Override
            protected Void doInBackground() throws Exception {

                while(scanning){
                    serialPorts = SerialPort.getCommPorts();
                    for (SerialPort serial:serialPorts){
                    }
                }
                return null;
            }
            
        };

        worker.execute();
    }

    private JPanel titre(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titre = new JLabel("Scanner RFID");
        titre.setFont(new Font(Fonts.textFont,Font.BOLD,25));
        titre.setForeground(Colors.text);
        titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
        panel.add(titre);
        panel.setOpaque(false);
        return panel;
    }

    private JPanel settings(){

        networkPanel();
        serialPortPanel();
        linkModule();

        //Create new instance of slidePanel
        slider = new JPanelSlider();

        //remove slidePanel background
        slider.setOpaque(false);

        //remove slidePane border
        slider.setBorder(BorderFactory.createEmptyBorder());

        //adding the panels to be slided in the slidePanel
        slider.add(serialPortPanel);
        slider.add(networkPanel);
        slider.add(linkModule);

        return slider;
    }

    // Port selection panel
    private void serialPortPanel(){
        serialPortPanel.setLayout(new BoxLayout(serialPortPanel,BoxLayout.Y_AXIS));
        
        //Create panels that will containt the instruction and the action  
        JPanel processPanel = new JPanel(new VerticalFlowLayout());
        JPanel actionPanel = new JPanel(new VerticalFlowLayout());
        JPanel comPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        //remove opacity of panel
        processPanel.setOpaque(false);
        actionPanel.setOpaque(false);
        serialPortPanel.setOpaque(false);
        comPanel.setOpaque(false);
        buttonPanel.setOpaque(false);

        //Create label for instructions
        Labels port = new Labels("Choisissez le port du", Fonts.textFont, Colors.grey, 25);
        Labels portSuite = new Labels("module parmis la liste", Fonts.textFont, Colors.grey, 25);
        port.isLight(true);
        portSuite.isLight(true);

        //adding the instructions to the processPanel
        processPanel.add(port);processPanel.add(portSuite);

        //Create a combobox for comport choice
        comPorts = new JComboBox<>();

        
        
        comPorts.setPreferredSize(new Dimension(100,50));
        comPorts.setBorder(new FlatLineBorder(new Insets(10,10,10,10), Colors.purple,3,20));

        //create button to pass to the next slide
        Buttons bouton = new Buttons("Suivant");

        //add the comPort combo to the comPanel
        comPanel.add(comPorts);

        //adding the button to the actionPanel
        buttonPanel.add(bouton);
        actionPanel.add(comPanel);
        actionPanel.add(buttonPanel);

        //adding action to the button
        bouton.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                connectToPort();
                slider.nextPanel(4, networkPanel,JPanelSlider.left);
                steps.setIcon(new ImageIcon(new Sary().Resize("img/two.png",300,22)));
            }
        });

        //adding the process and action panel to the main container
        serialPortPanel.add(processPanel);serialPortPanel.add(actionPanel);
    }

    // Submitting network information to the module
    private void networkPanel(){
        networkPanel.setLayout(new BoxLayout(networkPanel,BoxLayout.Y_AXIS));
        networkPanel.setOpaque(false);

        //Panels
        JPanel processPanel = new JPanel(new VerticalFlowLayout());
        JPanel middlePanel = new JPanel();
        JPanel actionPanel = new JPanel(new VerticalFlowLayout(false,false));
        JPanel buttonPanel = new JPanel();

        JPanel ssidPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));JPanel ssFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel passPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));JPanel passFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JPanel gridTest = new JPanel(new GridLayout(2,2));

        processPanel.setOpaque(false);
        actionPanel.setOpaque(false);
        ssFieldPanel.setOpaque(false);
        passFieldPanel.setOpaque(false);
        buttonPanel.setOpaque(false);
        ssidPanel.setOpaque(false);
        passPanel.setOpaque(false);
        middlePanel.setOpaque(false);
        gridTest.setOpaque(false);

        //Customize some panel
        gridTest.setBorder(new FlatLineBorder(new Insets(10,10,10,10), Colors.stroke, 1, 20));

        Labels port = new Labels("Connecter le module ", Fonts.textFont, Colors.grey, 25);
        Labels portSuite = new Labels("à un réseau wifi", Fonts.textFont, Colors.grey, 25);
        port.isLight(true);
        portSuite.isLight(true);
        
        //ssid and pass
        Labels ssid = new Labels("Wifi SSID: ",Fonts.textFont,Colors.grey,15);
        Labels pass = new Labels("mot de passe: ",Fonts.textFont,Colors.grey,15);
        JTextField ssField = new JTextField();
        JTextField passField = new JTextField();
        ssField.setPreferredSize(new Dimension(150,40));
        ssField.setBorder(new FlatLineBorder(new Insets(2,10,2,10), Colors.purple,3,20));
        passField.setPreferredSize(new Dimension(150,40));
        passField.setBorder(new FlatLineBorder(new Insets(2,10,2,10), Colors.purple,3,20));
        ssidPanel.setBorder(BorderFactory.createEmptyBorder(13, 0, 0, 0));
        passPanel.setBorder(BorderFactory.createEmptyBorder(13, 0, 0, 0));
 
        //Buttons
        Buttons previous = new Buttons("Précedent");
        previous.isOutlined(true);
        Buttons next = new Buttons("Suivant");

        previous.addMouseListener(new MouseInputAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);

                slider.nextPanel(4, serialPortPanel, JPanelSlider.right);
                steps.setIcon(new ImageIcon(new Sary().Resize("img/one.png",300,22)));
            }
            
        });
        next.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                slider.nextPanel(4, linkModule, JPanelSlider.left);
                steps.setIcon(new ImageIcon(new Sary().Resize("img/three.png",300,22)));
            }   
        });

        //Addings

        ssidPanel.add(ssid);ssFieldPanel.add(ssField);
        passPanel.add(pass);passFieldPanel.add(passField);
        gridTest.add(ssidPanel);gridTest.add(ssFieldPanel);
        gridTest.add(passPanel);gridTest.add(passFieldPanel);

        processPanel.add(port);processPanel.add(portSuite);
        buttonPanel.add(previous);
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(next);

        /*actionPanel.add(ssidPanel);
        actionPanel.add(passPanel);*/
        actionPanel.add(gridTest);
        actionPanel.add(Box.createVerticalStrut(10));
        actionPanel.add(buttonPanel);

        middlePanel.add(actionPanel);
        
        networkPanel.add(processPanel);
        networkPanel.add(middlePanel);

        // Fa inona zany? 
    }

    private void linkModule(){
        linkModule.setLayout(new BoxLayout(linkModule,BoxLayout.Y_AXIS));

        //Creating panels
        JPanel insPanel = new JPanel(new VerticalFlowLayout());
        JPanel butPanel = new JPanel();
        JPanel connectPanel = new JPanel();

        //Remove opacity
        linkModule.setOpaque(false);
        insPanel.setOpaque(false);
        butPanel.setOpaque(false);
        connectPanel.setOpaque(false);

        //Labels
        Labels port = new Labels("Connecter le logiciel", Fonts.textFont, Colors.grey, 25);
        Labels portSuite = new Labels("au module", Fonts.textFont, Colors.grey, 25);
        port.isLight(true);
        portSuite.isLight(true);

        //Buttons
        Buttons previous = new Buttons("Précedent");
        previous.isOutlined(true);
        Buttons next = new Buttons("Terminé");
        Buttons module = new Buttons("Connecter avec le module ");
        module.setBackground(Colors.text);

        previous.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                slider.nextPanel(4, networkPanel, JPanelSlider.right);
                steps.setIcon(new ImageIcon(new Sary().Resize("img/two.png",300,22)));
            }
        });

        //Addings 
        insPanel.add(port);
        insPanel.add(portSuite);
        butPanel.add(previous);
        butPanel.add(next);
        connectPanel.add(module);

        linkModule.add(insPanel);
        linkModule.add(connectPanel);
        linkModule.add(butPanel);
    }

    private JPanel steps(){
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        steps.setIcon(new ImageIcon(new Sary().Resize("img/one.png",300,22)));

        panel.add(steps);
        return panel;
    }
}
