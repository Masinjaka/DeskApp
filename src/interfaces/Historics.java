package interfaces;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.formdev.flatlaf.ui.FlatLineBorder;
import com.intellij.openapi.ui.VerticalFlowLayout;

import utilities.Colors;
import utilities.Fonts;
import utilities.dispositif.DateAndTime;
import utilities.dispositif.DispositifItem;
import utilities.historic.Historic;
import utilities.historic.HistoricRenderer;

public class Historics extends JPanel {

    public Historics(){
        this.setLayout(new BorderLayout(10,0));
        this.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        //********************* SETTING UP ACTUAL HISTORIC PANEL *************************
        JPanel panelStory = new JPanel();
        panelStory.setLayout(new BoxLayout(panelStory,BoxLayout.Y_AXIS));
        panelStory.setBackground(Colors.backgrounds);
        panelStory.setBorder(new FlatLineBorder(new Insets(17,10,15,10), Colors.stroke,1,20));
        
        //......................................................................
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel title = new JLabel("Historique");
        title.setForeground(Colors.text);
        title.setFont(new Font(Fonts.textFont,Font.BOLD,22));

        //......................................................................
        JScrollPane pane = new JScrollPane();
        DefaultListModel<Historic> model = new DefaultListModel<>();
        JList<Historic> list = new JList<>();

        //Little customization
        list.setBackground(Colors.backgrounds);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(4, 6, 0, 0));
        pane.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        pane.setOpaque(false);
        titlePanel.setOpaque(false);

        //......................................................................
        list.setModel(model);
        list.setCellRenderer(new HistoricRenderer());
        pane.setViewportView(list);
        model.addElement(new Historic("Dispositif.png", "Ramanandraibe", "09h30-16h00","09h15", "A temps"));
        model.addElement(new Historic("useraa.png", "Andrianasolo", "09h30-12h00","09h15", "A temps"));

        // Putting in place in the actual historicPanel
        titlePanel.add(title);
        panelStory.add(titlePanel);panelStory.add(pane);

        //********************* SETTING UP DATE PANEL *************************
        JPanel panelDate = new JPanel();
        panelDate.setLayout(new BoxLayout(panelDate,BoxLayout.Y_AXIS));
        panelDate.setBackground(Colors.backgrounds);
        panelDate.setPreferredSize(new Dimension(280,0));
        panelDate.setBorder(new FlatLineBorder(new Insets(17,10,15,10), Colors.stroke,1,20));

        //-----------------------------------------------------------
        JPanel topDevicePanel = new JPanel(new VerticalFlowLayout(VerticalFlowLayout.TOP));
        topDevicePanel.setOpaque(false);

        JPanel devicePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel deviceLabel = new JLabel("Dispositifs");
        
        JPanel horlogePanel = new JPanel();
        horlogePanel.setLayout(new BoxLayout(horlogePanel, BoxLayout.Y_AXIS));
        //-----------------------------------------------------------

        //Customization
        deviceLabel.setForeground(Colors.text);
        deviceLabel.setFont(new Font(Fonts.textFont,Font.BOLD,22));
        devicePanel.setOpaque(false);
        devicePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        horlogePanel.setBackground(Colors.purple);
        horlogePanel.setBorder(new FlatLineBorder(new Insets(10,10,10,10), Colors.purple,0,20));

        //Putting in place 
        devicePanel.add(deviceLabel);
        topDevicePanel.add(devicePanel);
        topDevicePanel.add(new DispositifItem("Scanner de badge"));
        topDevicePanel.add(Box.createVerticalBox());
        topDevicePanel.add(new DispositifItem("Lecteur biometrique"));

        //.....................date and devices......................
        horlogePanel.add(new DateAndTime());
        panelDate.add(topDevicePanel);panelDate.add(horlogePanel);
        

        this.add(panelStory,BorderLayout.CENTER);
        this.add(panelDate,BorderLayout.EAST);

    }
    
}
