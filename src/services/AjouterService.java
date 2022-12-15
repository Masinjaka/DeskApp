package services;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JDialog;
import javax.swing.JFrame;

import interfaces.Ajouter;

public class AjouterService extends JDialog {

	/**
	 * Classe pour afficher le menu d'ajout dans une 
	 * dialogue
	 */
	private static final long serialVersionUID = 1L;

	private Ajouter ajouter;

	public AjouterService() {
		
		ajouter = new Ajouter(new JFrame());
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
	public Ajouter getAjouter() {
		return ajouter;
	}
	public void setAjouter(Ajouter ajouter) {
		this.ajouter = ajouter;
	}
	
	
	
}
