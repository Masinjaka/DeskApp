package services;

import com.fazecast.jSerialComm.SerialPort;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingWorker;

import diu.swe.habib.JPanelSlider.JPanelSlider;
import interfaces.ScannerRFID;
import utilities.Sary;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.PrintWriter;

public class ScannerRFIDService {
    private ScannerRFID scanner = new ScannerRFID();

    private SerialPort[] serialPorts;
    private SerialPort serialPort;
    private boolean scanning = true;

    OutputStream out;

    public ScannerRFIDService() {
        // scanning
        port_scanning();
        // adding action to the button
        scanner.getBouton().addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                connectToPort();

            }
        });

        // bouton next
        scanner.getNext().addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                checkAndSendData();
                scanner.getSlider().nextPanel(4, scanner.getLinkModule(), JPanelSlider.left);
                scanner.getSteps().setIcon(new ImageIcon(new Sary().Resize("img/three.png", 300, 22)));
            }
        });

        // bouton précedent
        scanner.getPrevious().addMouseListener(new MouseInputAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);

                scanner.getSlider().nextPanel(4, scanner.getSerialPortPanel(), JPanelSlider.right);
                scanner.getSteps().setIcon(new ImageIcon(new Sary().Resize("img/one.png", 300, 22)));
            }

        });

    }

    // connec to the port
    // selected---------------------------------------------------------------------------------------
    public void connectToPort() {
        if (scanner.getComPorts().getItemCount()==0) {
            JOptionPane.showMessageDialog(null, "Connecter votre dispositif");
        } else {
            String selectedPort = (String) scanner.getComPorts().getSelectedItem();
            serialPort = SerialPort.getCommPort(selectedPort);
            serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
            serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
            if (serialPort.openPort()) {
                scanner.getSlider().nextPanel(4, scanner.getNetworkPanel(), JPanelSlider.left);
                scanner.getSteps().setIcon(new ImageIcon(new Sary().Resize("img/two.png", 300, 22)));
                JOptionPane.showMessageDialog(null, "Connected to " + selectedPort);
                scanning = false;
            } else {
                JOptionPane.showMessageDialog(null, "Failed to connect to " + selectedPort);
            }
        }

    }
    // scaning
    // port------------------------------------------------------------------------------------------------------

    public void port_scanning() {
        SwingWorker worker = new SwingWorker<Void, String>() {

            @Override
            protected Void doInBackground() throws Exception {

                while (scanning) {
                    serialPorts = SerialPort.getCommPorts();
                    for (SerialPort serialPort : serialPorts) {
                        String com = serialPort.getSystemPortName();
                        publish(com);
                    }

                }
                return null;
            }

            @Override
            protected void process(List<String> chunks) {

                // ? Récupérer le dernier élement du tableau
                String comPort = chunks.get(0);
                if (!comPort.equals(scanner.getComPorts().getItemAt(0))) {
                    scanner.getComPorts().removeAllItems();
                    scanner.getComPorts().addItem(comPort);
                }

            };

        };

        worker.execute();
    }

    //Methode pour verifier et envoyer le ussid et le mot de passe -----------------------------------------------------------------
    public void  checkAndSendData(){

        PrintWriter writer = new PrintWriter(serialPort.getOutputStream());
        
        if(scanner.getSsField().getText().equals("")|| scanner.getPassField().getText().equals("")){
            JOptionPane.showMessageDialog(null, "Remplissez les champs vide", "champ vide", 0, new ImageIcon(new Sary().Resize("img/alert.png", 50, 50)));
        }
        else{

            writer.println(scanner.getSsField().getText() +"/"+scanner.getPassField().getText());
            writer.flush();
            writer.close();
           /*  byte[] ssid=("a"+scanner.getSsField().getText()).getBytes();
           // byte[] pass=("b"+scanner.getPassField().getText()).getBytes();
            try {
                out.write(ssid);
                out.flush();
                
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            System.out.println("envoye de donné terminer");

        }

        }


    public ScannerRFID getScanner() {
        return scanner;
    }

    public void setScanner(ScannerRFID scanner) {
        this.scanner = scanner;
    }

    public boolean isScanning() {
        return scanning;
    }

    public void setScanning(boolean scanning) {
        this.scanning = scanning;
    }

    
}
