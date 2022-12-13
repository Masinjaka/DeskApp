package services;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputAdapter;

import java.awt.event.MouseEvent;

import interfaces.Dashboard;
import interfaces.Menus;

public class MenuServices {
    
    private Menus menu = new Menus();
    private Dashboard dashboard = new Dashboard();

    public MenuServices(){
        
        menu.getMenuList().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    switch (menu.getMenuList().getSelectedIndex()){
                        case 0:
                            dashboard.load(dashboard.getHistoricService().getHistorics());
                            dashboard.getWelcomeLabel().setText("Tongasoa");
                            break;
                        case 1:
                            dashboard.load(dashboard.getClockInService().getClock_in());
                            dashboard.getWelcomeLabel().setText("Début de service");
                            break;
                        case 2:
                            dashboard.load(dashboard.getClockOutService().getClock_out());
                            dashboard.getWelcomeLabel().setText("Fin de service");
                            break;
                        case 3:
                            dashboard.load(dashboard.getPersonneService().getPersonnels());
                            dashboard.getWelcomeLabel().setText("Personnels");
                            break;
                    }
                }
                
            }
            
        });

        menu.getSetting().addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                menu.getMenuList().clearSelection();
                menu.getSetting().setActive(true);

                //Show setting panel
                dashboard.load(dashboard.getParametreService().getParametre());
                dashboard.getWelcomeLabel().setText("Paramètres");

            }
        });
    }

    
    public Menus getMenu() {
        return menu;
    }

    public void setMenu(Menus menu) {
        this.menu = menu;
    }


    public Dashboard getDashboard() {
        return dashboard;
    }


    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    

}
