package services;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import interfaces.Parametre;

public class ParametreService {
    private Parametre parametre = new Parametre();
    
    public ParametreService(){

        parametre.getList().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                if(!e.getValueIsAdjusting()){
                    switch(parametre.getList().getSelectedIndex()){
                        case 0:
                            parametre.load(parametre.getApparence());
                            break;
                        case 1:
                            parametre.load(parametre.getRfid());
                            break;
                        case 2:
                            parametre.load(parametre.getAccount());
                            break;
                        case 3:
                            parametre.load(parametre.getExporter());
                            break;
                        case 4:
                        parametre.load(parametre.getApropos());
                            break;
                        case 5:
                            parametre.load(parametre.getTerm_Condition());
                            break;
                    }
                }
                
            }
            
        });
        
    }

    public Parametre getParametre() {
        return parametre;
    }

    public void setParametre(Parametre parametre) {
        this.parametre = parametre;
    }

    
}
