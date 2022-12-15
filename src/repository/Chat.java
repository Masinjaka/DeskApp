package repository;

public class Chat implements Animal {

    public Chat(){
        
    }

    @Override
    public void son() {
        System.out.println("Miaou");
        
    }

    @Override
    public void peau() {
        System.out.println("Poil à fourure");
    }

    @Override
    public void demarche() {
        System.out.println("Sur 4 pattes, il retombe toujour sur ces pattes");
    }
    
}
