package interfaces;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.formdev.flatlaf.ui.FlatLineBorder;

import utilities.Colors;
import utilities.checkings.Overview;
import utilities.checkings.WorkerCheck;
import utilities.historic.HistoricRenderer;

public class ClockIn extends JPanel{

    private JList<WorkerCheck> list;

    public ClockIn(){
        this.setLayout(new BorderLayout(10,0));
        this.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        this.add(poitagePanel(),BorderLayout.CENTER);
        this.add(Overview.overviewInfo(),BorderLayout.EAST);
    }
    private JPanel poitagePanel(){

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(new FlatLineBorder(new Insets(0,10,10,10), Colors.stroke,1,20));
        panel.setBackground(Colors.backgrounds);

        JScrollPane pane = new JScrollPane();
        DefaultListModel<WorkerCheck> model = new DefaultListModel<>();
        list = new JList<>();

        list.setBackground(Colors.backgrounds);
        pane.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        pane.setOpaque(false);

        list.setModel(model);
        list.setCellRenderer(new HistoricRenderer());
        pane.setViewportView(list);
        model.addElement(new WorkerCheck("emma.jpg", "MAHAVIARISOA Sitraka Emma", "7h00-18h00", "7h15"));
        model.addElement(new WorkerCheck("cecilia.jpg", "RAZAKAHARISOA Cecilia", "7h00-18h00", "7h15"));

        panel.add(pane);
        return panel;
    }
    public JList<WorkerCheck> getList() {
        return list;
    }
    public void setList(JList<WorkerCheck> list) {
        this.list = list;
    }

    

}
