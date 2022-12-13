package services;

import interfaces.Historics;

public class HistoricService {

    private Historics historics = new Historics();

    public HistoricService(){
        
    }

    public Historics getHistorics() {
        return historics;
    }

    public void setHistorics(Historics historics) {
        this.historics = historics;
    }
    
    
}
