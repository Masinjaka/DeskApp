package utilities.checkings;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.formdev.flatlaf.ui.FlatLineBorder;
import com.intellij.openapi.ui.VerticalFlowLayout;

import utilities.Colors;
import utilities.Fonts;
import utilities.Sary;
import utilities.historic.HistoricRenderer;

public class Overview extends JPanel {
    
    private JList<LazyWorker> list;

    public Overview(){}

    public JPanel overviewInfo(){
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        //panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(new FlatLineBorder(new Insets(5,10,10,10), Colors.stroke,1,20));
        panel.setBackground(Colors.backgrounds);
        
        //-------------------- PERCENTAGE PANEL -----------------------------------
        JPanel percentagePanel = new JPanel(new VerticalFlowLayout());
        percentagePanel.setBorder(new FlatLineBorder(new Insets(10,0,10,0), Colors.stroke,0,20));
        percentagePanel.setBackground(Colors.backgrounds);

        percentagePanel.add(new Pourcentage("presence.png", "Taux de présence", "85%"));
        percentagePanel.add(Box.createVerticalStrut(10));
        percentagePanel.add(new Pourcentage("ponctuel.png", "Taux de ponctualité", "93%"));

        //---------------------  ABSCENCE PANEL -------------------------------

        JPanel absentPanel = new JPanel();
        absentPanel.setBackground(Colors.backgrounds);
        absentPanel.setLayout(new BoxLayout(absentPanel,BoxLayout.Y_AXIS));
        absentPanel.setBorder(new FlatLineBorder(new Insets(10,10,10,10), Colors.stroke,0,20));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setOpaque(false);

        JLabel icon = new JLabel(new ImageIcon(new Sary().Resize("img/writing.png", 20, 20)));
        icon.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 5));
        
        JLabel title = new JLabel("Résumé d'hier");
        title.setForeground(Colors.text);
        title.setFont(new Font(Fonts.textFont,Font.BOLD,18));

        //---------------------- LIST OF LAZY PERSON ------------------
        JScrollPane pane = new JScrollPane();
        DefaultListModel<LazyWorker> model = new DefaultListModel<>();
        list = new JList<>();

        pane.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        list.setBackground(Colors.backgrounds);
        list.setModel(model);
        list.setCellRenderer(new HistoricRenderer());
        pane.setViewportView(list);

        titlePanel.add(icon);
        titlePanel.add(title);

        absentPanel.add(titlePanel);
        absentPanel.add(pane);        

        panel.add (percentagePanel);
        panel.add(absentPanel);
        return panel;
    }

    public JList<LazyWorker> getList() {
        return list;
    }

    public void setList(JList<LazyWorker> list) {
        this.list = list;
    }

    

}
