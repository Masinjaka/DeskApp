 package interfaces;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.intellij.openapi.ui.VerticalFlowLayout;

import utilities.Colors;
import utilities.Fonts;
import utilities.ImageProfile;
import utilities.Labels;
import utilities.Sary;
import utilities.ajouter.ComboHours;

public class Ajouter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String image = "Dummy.png";
	public static boolean getCarte;

	private JScrollPane scroll = new JScrollPane();
	private JPanel allOfThem = new JPanel(new VerticalFlowLayout());

	private JPanel infoPerso = new JPanel();
	private JPanel infoPoste = new JPanel();
	private JPanel infoId = new JPanel(new VerticalFlowLayout());
	//private JPanel validation = new JPanel(new FlowLayout(FlowLayout.RIGHT));

	// ************ Dans le panel infoPerso ************************
	private JPanel splitting = new JPanel();

	private JPanel infoPane = new JPanel(new VerticalFlowLayout());
	private Labels nom, prenom, cin, photo;
	public static ImageProfile getPic = new ImageProfile();
	public static JLabel icon = new JLabel();
	public static JTextField tnom, tprenom, tcin;

	//private String chemainProfil = File.separator + "img" + File.separator + "workers" + File.separator;

	private JPanel photoPane = new JPanel(new VerticalFlowLayout(VerticalFlowLayout.CENTER, 0, 20, false, false));

	// *************************** Dans le panel infoPoste*******************
	private Labels titre, entree, sortie, semaine;
	public static JTextField tTitre, tHeure;
	private JPanel parSem = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel choixHeure = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	//Radio button varié fixé
	public static JRadioButton aleatoire = new JRadioButton("Variée");
	public static JRadioButton fixed = new JRadioButton("Fixée");
	
	private ButtonGroup bg = new ButtonGroup();

	private JPanel pService = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pHeure = new JPanel(new FlowLayout(FlowLayout.LEFT));

	private JPanel containCont = new JPanel(new VerticalFlowLayout());
	private JPanel panelContinuite = new JPanel();
	private JPanel choixContinuite = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	//RADIO Button
	public static JRadioButton hContinue = new JRadioButton("Heure continue");
	public static JRadioButton hDiscontinue = new JRadioButton("Heure discontinue");
	
	private ButtonGroup bG = new ButtonGroup();

	private JPanel inOut = new JPanel();
	private JPanel panIn = new JPanel(new VerticalFlowLayout());
	private JPanel panOut = new JPanel(new VerticalFlowLayout());

	/*private JButton add = new JButton();
	private JPanel longPane = new JPanel();
	private JPanel containAdd = new JPanel();*/

	// ********************Panel identification externe ***********************

	private JPanel pCarte = new JPanel(new VerticalFlowLayout());
	//private JPanel pFinger = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private Labels hintCarte = new Labels("Passez une carte vierge sur le dispositif",Fonts.textFont, Colors.purple, 12);
	public static Labels passezCarte = new Labels("Carte d'identification manquante",Fonts.textFont,Colors.purple,12);
	//private String codeCarte = null;
	public static int error = 015;

	private JPanel pButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	public static JButton ok = new JButton("Ajouter");
	
	/* COMBO HOURS FOR DATE AND TIME*/
	private ComboHours debut1 = new ComboHours();
	private ComboHours fin1 = new ComboHours();
	private ComboHours debut2 = new ComboHours();
	private ComboHours fin2 = new ComboHours();
	private boolean hasExtraHours = false;

	//Constructor
	public Ajouter(JFrame fr) {

		getCarte = true;

		this.setLayout(new BorderLayout());

		// ********************* INFORMATION DU PERSONNEL************************

		informationPersonnel(fr);

		// ************************* INFORMATION SUR LE POSTE**********************

		informationPoste();

		// ************************** INFORMATION SUR L'IDENTIFICATION EXTERNE
		// *******************

		identification();

		// ***************** OK *************

		pButton.add(ok);
		ok.setFont(new Font("Century Gothic", Font.PLAIN, 15));

		scroll.setViewportView(allOfThem);

		// */*/*/*/*Mis en place/*/*/*/*/*
		allOfThem.add(infoPerso);
		allOfThem.add(infoPoste);
		allOfThem.add(infoId);
		this.add(scroll, BorderLayout.CENTER);
		this.add(pButton, BorderLayout.SOUTH);
	}

	private void identification() {

		passezCarte.setIcon(new ImageIcon(new Sary().Resize("img/alert.png", 17, 15)));
		pCarte.add(hintCarte);
		pCarte.add(passezCarte);
		pCarte.setBorder(BorderFactory.createTitledBorder("ID de la carte"));

		infoId.setBorder(BorderFactory.createTitledBorder("Identification"));

		infoId.add(pCarte);
	}

	private void informationPoste() {

		infoPoste.setLayout(new VerticalFlowLayout());
		infoPoste.setBorder(BorderFactory.createTitledBorder("Information sur le poste"));

		titre = new Labels("Titre du poste",Fonts.textFont, Colors.text,12);
		new Labels("Heure de travail", Fonts.textFont, Colors.text,12);
		new Labels("Debut et fin de service", Fonts.textFont, Colors.text,12);
		new Labels("Continuité", Fonts.textFont, Colors.text,12);
		entree = new Labels("Début",Fonts.textFont, Colors.text,12);
		sortie = new Labels("Fin",Fonts.textFont, Colors.text,12);
		semaine = new Labels("/Semaine",Fonts.textFont, Colors.text,12);

		tTitre = new JTextField();
		tHeure = new JTextField();
		tTitre.setPreferredSize(new Dimension(0, 25));
		tHeure.setPreferredSize(new Dimension(40, 25));
		parSem.add(tHeure);
		parSem.add(semaine);

		bg.add(aleatoire);
		bg.add(fixed);
		choixHeure.add(aleatoire);
		choixHeure.add(Box.createHorizontalStrut(100));
		choixHeure.add(fixed);

		bG.add(hContinue);
		bG.add(hDiscontinue);
		choixContinuite.add(hContinue);
		choixContinuite.add(Box.createHorizontalStrut(100));
		choixContinuite.add(hDiscontinue);

		pService.add(choixHeure);
		pService.setBorder(BorderFactory.createTitledBorder("Début et fin de service"));
		pHeure.add(parSem);
		pHeure.setBorder(BorderFactory.createTitledBorder("Heure de travail"));

		// panelContinuite.add(continuite);
		panelContinuite.setLayout(new BoxLayout(panelContinuite, BoxLayout.Y_AXIS));
		panelContinuite.setBorder(BorderFactory.createTitledBorder("Continuite"));
		containCont.add(choixContinuite);
		containCont.add(inOut);


		panelContinuite.add(containCont);
		/*panelContinuite.add(containAdd);*/
		panelContinuite.setVisible(false);
		
		/*-------Valeur initiale pour le choix d'heure en mode continue------*/
		inOut.setLayout(new BoxLayout(inOut, BoxLayout.X_AXIS));
		panIn.add(entree);
		panIn.add(debut1);

		panOut.add(sortie);
		panOut.add(fin1);

		inOut.add(panIn);
		inOut.add(panOut);

		//Choix horraire aléatoire
		aleatoire.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelContinuite.setVisible(false);

			}
		});
		//Choix horraire fixée
		fixed.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelContinuite.setVisible(true);

			}
		});
		
		
		aleatoire.setSelected(true);
		fixed.setEnabled(true);

		//choix heurecontinue fixée
		hContinue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Juste enlever les champs pour ajouter de l'heure discontinue
				if(hasExtraHours) {
					panIn.remove(debut2);
					panOut.remove(fin2);
					hasExtraHours = false;
				}
					
				panIn.revalidate();
				panOut.revalidate();
			

			}
		});
		
		//choix heure discontinue fixée
		hDiscontinue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				/*containAdd.setVisible(true);*/
				if(!hasExtraHours) {
					panIn.add(debut2);
					panOut.add(fin2);
					hasExtraHours = true;
				}
				panIn.revalidate();
				panOut.revalidate();

			}
		});
		hContinue.setSelected(true);

		//Bouton + pour ajouter de nouveau tranche d'heure^

		infoPoste.add(titre);
		infoPoste.add(tTitre);
		infoPoste.add(pHeure);
		infoPoste.add(pService);
		infoPoste.add(panelContinuite);

	}

	private void informationPersonnel(JFrame frame) {
		
		// Création du champ à remplir
		nom = new Labels("Nom", Fonts.textFont, Colors.text,12);
		prenom = new Labels("Prénom",Fonts.textFont, Colors.text,12);
		cin = new Labels("Carte d'identité", Fonts.textFont, Colors.text,12);
		photo = new Labels("Photo", Fonts.textFont, Colors.text,15);

		tnom = new JTextField();
		tprenom = new JTextField();
		tcin = new JTextField();
		tnom.setPreferredSize(new Dimension(0, 25));
		tprenom.setPreferredSize(new Dimension(0, 25));
		tcin.setPreferredSize(new Dimension(0, 25));

		infoPane.add(nom);
		infoPane.add(tnom);
		infoPane.add(prenom);
		infoPane.add(tprenom);
		infoPane.add(cin);
		infoPane.add(tcin);

		// icon.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
		
		icon.setIcon(new ImageIcon(getPic.ResizeCercle("img/workers/Dummy.png", 100, 100, Colors.purple)));
		
		photoPane.add(photo);
		photoPane.add(icon);
		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		System.out.println(path);
		// -----------------ACTION POUR SELECTIONNER UNE IMAGE POUR LE
		// PROFIL------------

		icon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//Image Picker
		icon.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				super.mouseClicked(arg0);

				// Ouvrir le filedialog
				FileDialog dialog = new FileDialog(frame, "Choisi une image", FileDialog.LOAD);
				dialog.setFile("*.jpg;*.jpeg;*.png;*.gif");
				dialog.setVisible(true);

				// recuperer l'image du file dialog
				String file = dialog.getFile();
				String dir = dialog.getDirectory();

				// Copier le fichier reéu vers le dossier du projet
				if (file == null) {
					image = "Dummy.png";
				} else {
					String ic = dir + file;
					File img = new File(ic);
					System.out.println(path + File.separator + img.getName());
					image = img.getName();

					try {
						// Copier l'image dans le dossier du projet
						Files.copy(
								img.toPath(), (new File(path + File.separator + "img" + File.separator + "workers"
										+ File.separator + img.getName()).toPath()),
								StandardCopyOption.REPLACE_EXISTING);
						icon.setIcon(new ImageIcon(
								getPic.ResizeCercle("img/workers/" + img.getName(), 100, 100, Colors.purple)));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		});// Fin MouseListener

		// ----------------SPLITTING NAME FIELD AND IMAGE FIELD-------------------
		splitting.setLayout(new BoxLayout(splitting, BoxLayout.X_AXIS));
		splitting.add(infoPane);
		splitting.add(Box.createHorizontalGlue());
		splitting.add(photoPane);

		infoPerso.setLayout(new BorderLayout());
		infoPerso.add(splitting, BorderLayout.CENTER);
		infoPerso.setBorder(BorderFactory.createTitledBorder("Information personnel"));
	}


	//Getters and Setters 
	public ComboHours getDebut1() {
		return debut1;
	}

	public void setDebut1(ComboHours debut1) {
		this.debut1 = debut1;
	}

	public ComboHours getFin1() {
		return fin1;
	}

	public void setFin1(ComboHours fin1) {
		this.fin1 = fin1;
	}

	public ComboHours getDebut2() {
		return debut2;
	}

	public void setDebut2(ComboHours debut2) {
		this.debut2 = debut2;
	}

	public ComboHours getFin2() {
		return fin2;
	}

	public void setFin2(ComboHours fin2) {
		this.fin2 = fin2;
	}

	
	
}
