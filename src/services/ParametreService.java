package services;

import interfaces.Parametre;

public class ParametreService {
    private Parametre parametre = new Parametre();
    
    public ParametreService(){
        
    }

    public Parametre getParametre() {
        return parametre;
    }

    public void setParametre(Parametre parametre) {
        this.parametre = parametre;
    }

    
}
