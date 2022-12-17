package services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import tasks.WebSocket;

public class WebSocketService {

    // Créer un WebSocket
    WebSocket web_socket = new WebSocket();
    
    // ? Constructeur
    public WebSocketService(){

        Timer timer = new Timer(1/3, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                // *vérifier si il y a une erreur

                while(web_socket.isErreur()){
                    // Recommencer la connection 
                    web_socket.connecter();
                }
                
                // Récupérer un badge
                web_socket.getID_badge(); 
            }
            
        });

        // ? Demarrer le timer 
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }


    // Getters and Setters
    public WebSocket getWeb_socket() {
        return web_socket;
    }

    public void setWeb_socket(WebSocket web_socket) {
        this.web_socket = web_socket;
    }
    
    
}
