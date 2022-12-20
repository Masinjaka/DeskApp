package services;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.formdev.flatlaf.ui.FlatLineBorder;

import interfaces.Ajouter;
import interfaces.Template;

public class AjouterService extends JDialog {

	/**
	 * Classe pour afficher le menu d'ajout dans une 
	 * dialogue
	 */
	private static final long serialVersionUID = 1L;

	private Ajouter ajouter;
	private String carte = "";

	public AjouterService() {
		
		ajouter = new Ajouter(new JFrame());
		
		// Configurer l'UI du dialogue
		setupUI();
	
		// Ajouter dans la base de donnée.
		ajouter.getOk().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);

				/*
				 * il faut d'abord vérifier si tout les champs sont bien remplis
				 * ensuite il faut vérifier si la personne en question existe déjà dans la base de donnée
				 * Si tout ces conditions sont sans contrainte ou je ne sais quoi, alors on ajoute la personne dans la base
				 * 
				 */
				if(allFieldFilled()){
					System.out.println("insert data!");
				}

				
			}
		});
	
	}

	// Fonction qui vérifie si tout les champs sont bien remplis
	private boolean allFieldFilled(){

		boolean value = true;

		// Mettre tout les champs de texte dans une liste
		
		// Parcourir la liste
		for(JTextField fill:ajouter.getField()){

			// Vérifier si le champ de texte est vide
			if(fill.getText().isEmpty()){
				
				fill.setBorder(new FlatLineBorder(new Insets(10,10,10,10), Color.red,2,0));
				fill.setText("Veuillez remplir ce champs");
				fill.setForeground(Color.red);

				value = false;
				//break;
			}

		}
		
		return value;
	}

	// Fonction qui ajoute dans la base de donnée
	private void inserer(){

		//Liste des champs
		ArrayList<String> champs = new ArrayList<>();
		String image = ajouter.getImage();

		//Boucler les champs de texte
		for(JTextField field:ajouter.getField()){
			champs.add(field.getText());
		}

		Template.db_tables.getTablePersonnel().ajouter(champs.get(0), champs.get(1),champs.get(3),Long.parseLong(champs.get(2)),Integer.parseInt(champs.get(4)), this.carte,image, 0);
	}


	// Interface d'ajout
	private void setupUI(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(550,600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		add(ajouter,BorderLayout.CENTER);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				Ajouter.getCarte = true;
				System.out.println("Ferm� oh");
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}






	//Getter and setter
	public Ajouter getAjouter() {
		return ajouter;
	}
	public void setAjouter(Ajouter ajouter) {
		this.ajouter = ajouter;
	}
	
	
	
}
