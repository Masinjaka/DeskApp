package utilities.historic;

import java.awt.*;
import java.awt.event.*;

import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.MouseInputAdapter;

import utilities.Colors;

public class ToggleButton extends Component {
    
    // Attribut
    private Timer timer;
    private float location;
    private boolean selected;
    private boolean mouseOver;
    private float speed=1.2f;


    // ? Constructeur
    public ToggleButton(){

        setBackground(Colors.green);
        setPreferredSize(new Dimension(32,19));

        location = 2;
        // Animation du toggle
        this.timer = new Timer(1/3,new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(selected){
                    int endLocation = getWidth() - getHeight()+2;
                    
                    // Aller vers la droite
                    if(location < endLocation){

                        location += speed;
                        repaint();

                    }else{

                        // Arrêter l'animation
                        timer.stop();
                        location = endLocation;
                        repaint();
                    }


                }else{
                    
                    // Aller vers le gauche
                    int endLocation = 2;
                    if(location > endLocation){

                        location -= speed;
                        repaint();

                    }else{

                        timer.stop();
                        location = endLocation;
                        repaint();

                    }

                }
            }
            
        });
        this.timer.setRepeats(true);
        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)){
                    if(mouseOver){
                        selected = !selected;
                        timer.start();
                    }
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        
        // Créer un graphic 2D
        Graphics2D g2d = (Graphics2D) g;

        // Mettre de l'antialias sur le graphic
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        float alpha = getAlfa();

        if(alpha < 1){
            g2d.setColor(Colors.stroke);
            g2d.fillRoundRect(0, 0, width, height,  20, 20);
        }
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, width, height, 20, 20);
        g2d.setColor(Colors.backgrounds);
        g2d.setComposite(AlphaComposite.SrcOver);
        g2d.fillOval((int)location, 2, height-4, height-4);

        super.paint(g);
    }

    private float getAlfa(){

        float width = getWidth() - getHeight();
        float alpha = (location - 2) / width;

        if(alpha < 0){
            alpha = 0;
        }
        if(alpha > 1){
            alpha = 1;
        }

        return alpha;
    }
}
