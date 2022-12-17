package utilities.historic;

public class ToggleAnimation implements Runnable{


    private ToggleButton toggle;
    private boolean selected;
    private float location;
    private float speed=1f;

    private Thread thread;
    private volatile boolean flag = false;

    public ToggleAnimation(boolean selected,float location,ToggleButton toggle){

        this.toggle =  toggle;
        this.selected = selected;
        this.location = location;
    }

    // Pour démarrer l'animation
    public void start(){
        thread = new Thread(this);
        thread.start();
    }

    // Pour stopper l'animation
    public void stop(){
        flag = true;
    }

    @Override
    public void run() {

        while(!flag){

            if(selected){
                int endLocation = toggle.getWidth() - toggle.getHeight()+2;
                
                // Aller vers la droite
                if(location < endLocation){

                    location += speed;
                    toggle.revalidate();
                    toggle.repaint();

                }else{

                    // Arrêter l'animation
                    stop();
                    location = endLocation;
                    toggle.revalidate();
                    toggle.repaint();
                }


            }else{
                
                // Aller vers le gauche
                int endLocation = 2;
                if(location > endLocation){

                    location -= speed;
                    toggle.revalidate();
                    toggle.repaint();

                }else{

                    stop();
                    location = endLocation;
                    toggle.revalidate();
                    toggle.repaint();

                }

            }
            try {
                Thread.sleep(1000);

                

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                System.out.println(" Thread intérrompu");
            }
        }
        System.out.println(" Thread arrêté");
        return;
        
    }
    
}