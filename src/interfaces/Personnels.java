package interfaces;

import java.awt.BorderLayout;
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
import utilities.Sary;
import utilities.peronnel.Info;
import utilities.peronnel.WorkerCard;
import utilities.peronnel.WorkerInfo;
import utilities.peronnel.WorkerRenderer;

public class Personnels extends JPanel {

    private JList<WorkerCard> list;
    private WorkerInfo info;
    private JLabel add;

    public Personnels(){
        this.setLayout(new BorderLayout(10,0));
        this.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        this.add(personnelList(),BorderLayout.CENTER);
        this.add(personnelInfo(),BorderLayout.EAST);
    }

    public JPanel personnelList(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(new FlatLineBorder(new Insets(0,10,10,10), Colors.stroke,1,20));
        
        JScrollPane pane = new JScrollPane();
        DefaultListModel<WorkerCard> model = new DefaultListModel<>();
        list = new JList<>();

        /// Customization
        list.setBackground(Colors.backgrounds);
        pane.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        pane.setOpaque(false);
        panel.setBackground(Colors.backgrounds);

        /// Setting up list
        list.setModel(model);
        list.setCellRenderer(new WorkerRenderer());
        pane.setViewportView(list);
        model.addElement(new WorkerCard("masy.jpg", "MASINJAKA","Andrianomentsoa", "Lead developer"));
        model.addElement(new WorkerCard("useraa.png", "JESSICA","Miller", "Secretaire"));
        
        panel.add(pane);

        //------------------- Adding new emplyee-------------------
        JPanel addPanel = new JPanel();
        addPanel.setOpaque(false);

        add = new JLabel(new ImageIcon(new Sary().Resize("img/add.png", 45, 45)));
        addPanel.add(add);

        panel.add(addPanel);

        return panel;
    }

    // Right-sided worker information panel
    public JPanel personnelInfo(){
        
        JPanel panel = new JPanel(new VerticalFlowLayout());
        //panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(new FlatLineBorder(new Insets(10,10,10,10), Colors.stroke,1,20));
        panel.setBackground(Colors.backgrounds);

        info = new WorkerInfo("useraa.png", "MASINJAKA", "Andrianomentsoa");
        
        JPanel infoPanel = new JPanel(new VerticalFlowLayout());
        infoPanel.setBorder(new FlatLineBorder(new Insets(10,10,10,10), Colors.stroke,1,20));

        infoPanel.add(new Info("Carte ID", "220631007056"));
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(new Info("Poste", "RH"));
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(new Info("Heure de service", "7h00-16h00"));

        panel.add(info);
        panel.add(infoPanel);
        return panel;
    }


    
    public JList<WorkerCard> getList() {
        return list;
    }

    public void setList(JList<WorkerCard> list) {
        this.list = list;
    }

    public WorkerInfo getInfo() {
        return info;
    }

    public void setInfo(WorkerInfo info) {
        this.info = info;
    }

    public JLabel getAdd() {
        return add;
    }

    public void setAdd(JLabel add) {
        this.add = add;
    }
    
    
}
