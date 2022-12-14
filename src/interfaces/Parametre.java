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
import utilities.menu.Cell;
import utilities.menu.MenuItems;

public class Parametre extends JPanel {

    private JList<MenuItems> list;
    private JPanel placeholder,thirdParty;
    private Apparence apparence = new Apparence();
    private ScannerRFID rfid = new ScannerRFID();
    private Account account = new Account();
    private Apropos aprop= new Apropos();
    private Term_Condition TermCond = new Term_Condition();
    private Exporter exporte = new Exporter();

    public Parametre(){

        this.thirdParty  = apparence;

        this.setLayout(new BorderLayout(10,0));
        this.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        this.add(options(),BorderLayout.WEST);
        this.add(optionAction(),BorderLayout.CENTER);
    }
    private JPanel options(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(new FlatLineBorder(new Insets(0,10,10,10), Colors.stroke,1,20));
        panel.setBackground(Colors.backgrounds);

        list = new JList<>();
        DefaultListModel<MenuItems> model = new DefaultListModel<>();
        JScrollPane pane = new JScrollPane();

        list.setModel(model);
        list.setCellRenderer(new Cell());
        pane.setViewportView(list);

        model.addElement(new MenuItems("login", "Apparence"));
        model.addElement(new MenuItems("logout", "Scanner RFID"));
        model.addElement(new MenuItems("writing", "Compte"));
        model.addElement(new MenuItems("clipboard", "Exporter"));
        model.addElement(new MenuItems("disposition", "A propos"));
        model.addElement(new MenuItems("login", "Term & condition"));

        pane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        pane.setBackground(Colors.backgrounds);
        list.setBackground(Colors.backgrounds);

        panel.add(pane);

        return panel;
    }

    private JPanel optionAction(){
        placeholder = new JPanel();
        placeholder.setLayout(new BoxLayout(placeholder,BoxLayout.Y_AXIS));
        placeholder.setBorder(new FlatLineBorder(new Insets(0,10,10,10), Colors.stroke,1,20));
        placeholder.setBackground(Colors.backgrounds);

        placeholder.add(thirdParty);
        return placeholder;
    }               

    //Method to load setting content 
    public void load(JPanel panely){
        placeholder.remove(thirdParty);
        thirdParty = panely;
        placeholder.add(thirdParty);
        placeholder.revalidate();
        placeholder.repaint();
    }

    public JList<MenuItems> getList() {
        return list;
    }
    public void setList(JList<MenuItems> list) {
        this.list = list;
    }
    public Apparence getApparence() {
        return apparence;
    }
    public void setApparence(Apparence apparence) {
        this.apparence = apparence;
    }
    public ScannerRFID getRfid() {
        return rfid;
    }
    public void setRfid(ScannerRFID rfid) {
        this.rfid = rfid;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public  Apropos getApropos() {
        return aprop;
    }
    public void setApropos(Apropos aprop){
        this.aprop= aprop;
    }
    public Exporter getExporter(){
        return exporte;
    }
    public void setExporter(Exporter exporte){
        this.exporte= exporte;
    }
    public Term_Condition getTerm_Condition(){
        return TermCond;
    }
    public void setTerm_Condition (Term_Condition TermCond){
        this.TermCond = TermCond;
    }
}
