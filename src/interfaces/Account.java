package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;

import com.formdev.flatlaf.ui.FlatLineBorder;
import com.intellij.openapi.ui.VerticalFlowLayout;

import utilities.AsideLayout;
import utilities.Buttons;
import utilities.Colors;
import utilities.Fonts;
import utilities.Labels;
import utilities.Sary;
import utilities.menu.UserProfile;

public class Account extends JPanel {
    
    UserProfile profile = new UserProfile("user", "Username", "Occupation");
    Labels changePass;
    private JPanel top,center,bottom;
    public Account(){

        changePass = new Labels("Changer de compte",Fonts.textFont,Colors.text,15);
        
        this.top = topPanel();
        this.center = centerPanel();
        this.bottom = bottomPanel();

        

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(15,10,10,10));
        this.setOpaque(false);

        
        this.add(this.top,BorderLayout.NORTH);
        this.add(this.center,BorderLayout.CENTER);
        this.add(this.bottom,BorderLayout.SOUTH);
        
    }

    private JPanel topPanel(){
        //Panels
        JLabel logout = new JLabel(new ImageIcon(new Sary().Resize("img/getout.png",30,30)));
        logout.setBorder(BorderFactory.createEmptyBorder(18, 0, 0, 0));
        AsideLayout aside = new AsideLayout(profile, logout);

        return aside;
    }
    private JPanel centerPanel(){
        JPanel panel = new JPanel(new VerticalFlowLayout());
        panel.setOpaque(false);

        JPanel middelChanges = new JPanel();
        JPanel middle = new JPanel(new VerticalFlowLayout());
        middle.setOpaque(false);
        JPanel changes = new JPanel(new VerticalFlowLayout());
        changes.setBorder(new FlatLineBorder(new Insets(10,10,10,10), Colors.stroke,1,20));

        //Removings
        middelChanges.setOpaque(false);
        changes.setOpaque(false);

        //username label
        Labels usernameLabel = new Labels("Nom d'utilisateur","Arial",Colors.text,15);
        usernameLabel.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 0));
        //Edit logo
        JLabel edit = new JLabel(new ImageIcon(new Sary().Resize("img/edit_blue.png",25,25)));
        edit.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
        
        //Changind name textfield
        JTextField field = new JTextField("Username");
        field.setPreferredSize(new Dimension(150,40));
        field.setBorder(new FlatLineBorder(new Insets(2,10,2,10), Colors.purple,3,20));
        
        //textfield layout
        JPanel fieldLayout = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldLayout.setOpaque(false);
        fieldLayout.add(field);fieldLayout.add(edit);
       // AsideLayout fieldLayout = new AsideLayout(field, edit);

        //Password label
        Labels changePass = new Labels("Changer de mot de passe","Arial",Colors.text,15);
        changePass.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 0));

        //Edit logo password
        JLabel editPass = new JLabel(new ImageIcon(new Sary().Resize("img/edit_blue.png",25,25)));
        editPass.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        //Password layout
        JPanel  passChangeLayout = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passChangeLayout.setOpaque(false);
        passChangeLayout.add(changePass); passChangeLayout.add(editPass);
       //AsideLayout passChangeLayout = new AsideLayout(changePass, editPass);

        //Security question label
        Labels changeSQ = new Labels("Changer de question de sécurité","Arial",Colors.text,15);
        changeSQ.setBorder(BorderFactory.createEmptyBorder(3, 2, 0, 0));

        //Edit logo password
        JLabel editSQ = new JLabel(new ImageIcon(new Sary().Resize("img/edit_blue.png",25,25)));
        editSQ.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        //Password layout
        AsideLayout passSQLayout = new AsideLayout(changeSQ, editSQ);

        //----------------------- creating account --------------------------
        Buttons create = new Buttons("Créer un compte");
        create.isOutlined(true);
        create.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                load(topPanelCreate(), createPanel());
                change("Retour");
            }
        });

        //Addings 
        changes.add(usernameLabel);changes.add(fieldLayout);
        changes.add(Box.createVerticalStrut(10));
        changes.add(passChangeLayout);
        changes.add(Box.createVerticalStrut(10));
        changes.add(passSQLayout);

        middelChanges.add(changes);
        middle.add(middelChanges);
        middle.add(create);

        panel.add(middle);
        return panel;
    }
    private JPanel bottomPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setOpaque(false);
        changePass.setForeground(Colors.blue);

       changePass.addMouseListener(new MouseInputAdapter() {
            
       });
       
        panel.add(changePass);
        return panel;
    }

    private JPanel createPanel(){

        JPanel panel = new JPanel(new VerticalFlowLayout());
        panel.setOpaque(false);

        JPanel middelChanges = new JPanel();
        JPanel middle = new JPanel(new VerticalFlowLayout());
        middle.setOpaque(false);
        JPanel changes = new JPanel(new VerticalFlowLayout());
        changes.setBorder(new FlatLineBorder(new Insets(10,10,10,10), Colors.stroke,1,20));
        JPanel midButton = new JPanel();
        JPanel changesButton = new JPanel(new VerticalFlowLayout());
        //changesButton.setBorder(new FlatLineBorder(new Insets(10,10,10,10), Colors.stroke,1,20));
        
        //Removings
        middelChanges.setOpaque(false);
        midButton.setOpaque(false);
        changes.setOpaque(false);
        changesButton.setOpaque(false);

        //-------------- New username--------------

        //username label
        Labels usernameLabel = new Labels("Nom d'utilisateur","Arial",Colors.text,15);
        usernameLabel.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 0));
        
        //Changind name textfield
        JTextField field = new JTextField("Username");
        field.setPreferredSize(new Dimension(150,40));
        field.setBorder(new FlatLineBorder(new Insets(2,10,2,10), Colors.purple,3,20));
    
        //-------------- New passWord--------------
        Labels passLabel = new Labels("Créer un mot de passe","Arial",Colors.text,15);
        usernameLabel.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 0));
        
        //Changind name textfield
        JPasswordField passField = new JPasswordField("Username");
        passField.setPreferredSize(new Dimension(150,40));
        passField.setBorder(new FlatLineBorder(new Insets(2,10,2,10), Colors.purple,3,20));
    
        //-------------- Confirm passWord--------------
        Labels confirmLabel = new Labels("Confirmer le mot de passe","Arial",Colors.text,15);
        usernameLabel.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 0));
        
        //Changind name textfield
        JPasswordField confirmField = new JPasswordField("Username");
        confirmField.setPreferredSize(new Dimension(150,40));
        confirmField.setBorder(new FlatLineBorder(new Insets(2,10,2,10), Colors.purple,3,20));
    
        Buttons create = new Buttons("Créer un compte");
        
        //Addings 
        changes.add(usernameLabel);changes.add(field);
        changes.add(Box.createVerticalStrut(10));
        changes.add(passLabel);changes.add(passField);
        changes.add(Box.createVerticalStrut(10));
        changes.add( confirmLabel);changes.add(confirmField);
        changes.add(Box.createVerticalStrut(10));

        changesButton.add(create);
        midButton.add(changesButton);

        middelChanges.add(changes);
        middle.add(middelChanges);
        middle.add(midButton);

        panel.add(middle);
        return panel;
    }

    private JPanel topPanelCreate(){
        //Panels
        Labels titre = new Labels("Créer un compte", Fonts.textFont, Colors.blue, 25);
        
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        panel.add(titre);

        return panel;
    }

    private void load(JPanel ambony,JPanel apovony){

        this.remove(top);
        this.remove(center);

        this.top = ambony;
        this.center = apovony;
        this.add(top,BorderLayout.NORTH);
        this.add(center,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();

    }

    private void change(String text){

        changePass.setText(text);
        changePass.revalidate();
        changePass.repaint();

    }
}
