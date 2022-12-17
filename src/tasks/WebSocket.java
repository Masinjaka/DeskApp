package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class WebSocket {


    // Nouveau Socket
    Socket socket = null; 
    
    // Port
    static final int PORT = 8080; 
    
    // Signal d'erreur
    private boolean erreur = true;

    // ID Badge
    public static String badge = "";

    // Streamer
    BufferedReader br = null;

    // Message 
    public static String message = "";

    // Constructor
    public WebSocket(){}
    

    // Connecter au serveur
    public void connecter(){

        try {

            socket = new Socket("localhost", PORT);
            
            // Reinitialiser l'erreur si le socket est connecté
            if(socket.isConnected())
                this.erreur = false;
                message = "Connection avec le module établie";

            // Ouvrir un tampon de cannal de communication    
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) { this.erreur = true; message = "La connection avec le module à échouée";}
    }

    // Fonction qui recupère l'ID du badge
    public void getID_badge(){
        try {
            // Verifier si la communication avec le serveur n'est pas interompu
            if(socket.getInetAddress().isReachable(1000)){

                // il y un message
                if(br.ready()){

                    // Lire les données
                    badge = br.readLine();
                }
                
            }else{

                // Signaler une erreur
                this.erreur = true;
            }
        } catch (IOException e) {
            this.erreur = true;
        }
    }


    public boolean isErreur() {
        return erreur;
    }


    public void setErreur(boolean erreur) {
        this.erreur = erreur;
    }

    // Getter and Setter

    
    
}
