package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.SwingWorker;

import database.model.Historique;
import interfaces.Historics;
import interfaces.Template;
import tasks.Verifiable;
import utilities.historic.Historic;

public class HistoricService implements Verifiable{

    private Historics historics = new Historics();
    private String carte = "";
    LocalTime time = LocalTime.now();
    DefaultListModel<Historic> model = (DefaultListModel<Historic>) historics.getList().getModel();

    public HistoricService(){

        // ? Charger la liste
        load();

        // ? Actualiser la liste
        actualiser();
        /*
         * Ecrit ici une boucle de type Timer qui actualise l'historique tout les 1/3 de séconde 
         * et qui affiche une nouvelle personne uniquement s'il la nouvelle carte est dans la base de donnée 
         * 
         */
    }
    private void load(){

    

            SwingWorker work = new SwingWorker<Void, ArrayList<String[]>>() {
    
                @Override
                protected Void doInBackground() throws Exception {
                    ResultSet hst;
                    try {
                        hst = Template.db_tables.getHistorique().select();
                        String[] elts;
                        ArrayList<String[]> list = new ArrayList<>();
                        while (hst.next()) {
    
                            elts = new String[] {
                                    hst.getString("Photo"),
                                    hst.getString("Nom"),
                                    hst.getString("Heure"),
                                    hst.getString("Entre"),
                                    hst.getString("Presence"),
                                    String.valueOf(hst.getInt("id"))
                            };
                            list.add(elts);
                        }
                        publish(list);
    
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
    
                @Override
                protected void process(List<ArrayList<String[]>> chunks) {
                    super.process(chunks);
    
                    // ? Ajouter dans le model
                    for (String[] elt : chunks.get(chunks.size() - 1)) {
    
                        // mbola mila jerena tsara ito alouha ny zavatra rehetra
                        model.addElement(new Historic(elt[0], elt[1], elt[2], elt[3], elt[4])); //Integer.parseInt(elt[4]); 
                        System.out.println("Mandeha ihany ilay izy");
                        historics.revalidate();
                        historics.repaint();
    
                    }

                    historics.getList().setSelectedIndex(0);
                }
            };
    
            work.execute();
            // mbola tsy mety tsara ilay mmiaffiche azy @listen'ny historique de mbola hojerena tsara


            // fighting eonni!!
    
        
        //1- Maka donnée avy any @ table historique 
        //2- Afficher anazy eo am liste 
    }

    public void actualiser(){
        SwingWorker worker = new SwingWorker<Void, String[]>() {

            @Override
            protected Void doInBackground() throws Exception {

        // 1- Tsy vide le badge && tsy manao ajout 

                AjouterService Ajt = new AjouterService();

                // maka ny carte personnels
                ResultSet resultat;
                try {
                    resultat= Template.db_tables.getTablePersonnel().select();
                    String[] elts;
                    ArrayList<String[]> list = new ArrayList<>();
                    while (resultat.next()) {

                        elts = new String[] {
                                resultat.getString("Photo"),
                                resultat.getString("Nom"),
                                resultat.getString("Prenom"),
                                resultat.getString("Poste"),
                                String.valueOf(resultat.getInt("id"))
                        };
                        list.add(elts);
                    };

                }catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return null;

                    

                /*if (carte !=null ){//&& ajt.is.....(falses)
                     if (carte == Historique.getCarte()){

                     } //mbola ila alaina tany amin'ny base ny carte ho comparena aminy
                }*/
                

        // 2- Vérifier oe misy ao am base
        
        
         


        /*  3- Collecter donnée {
            nom et prenom
            tranche horraire 
            heure de pointage
        }*/
        //3- Séparer niditra et nivoaka 
        //4- Enregistrer any am base ny historique sy ny niditra/nivoaka 
        }

    } ;
}
    
   /* public void actualiser(AjouterService AJ) {

        SwingWorker worker = new SwingWorker<Void, String[]>() {

            @Override
            protected Void doInBackground() throws Exception {

                // ? Pendant que la fenêtre d'ajout détecte une carte
                while (AJ.isDetecting()) {

                    // Pause
                    Thread.sleep(20);

                    // ? Récupérer depuis la base
                    if (AjouterService.actualiser) {
                        ResultSet set = Template.db_tables.getTablePersonnel().select();
                        String[] elements;

                        while (set.next()) {

                            elements = new String[] {
                                    set.getString("Photo"),
                                    set.getString("Nom"),
                                    set.getString("Prenom"),
                                    set.getString("Poste"),
                                    String.valueOf(set.getInt("id"))
                            };
                            publish(elements);
                        }
                        AjouterService.actualiser = false;
                    }

                }
                return null;
            }

            @Override
            protected void process(List<String[]> chunks) {

                // ? Récupérer le dernier élement du tableau
                String[] retrieve = chunks.get(chunks.size() - 1);
                model.addElement(new WorkerCard(retrieve[0], retrieve[1], retrieve[2], retrieve[3],
                        Integer.parseInt(retrieve[4])));

            }
        };

        worker.execute();
    }*/

    public Historics getHistorics() {
        return historics;
    }

    public void setHistorics(Historics historics) {
        this.historics = historics;
    }

    @Override
    public boolean existe() {
        // Carte misy ao @ table personne ? 
        return false;
    }
    
}
