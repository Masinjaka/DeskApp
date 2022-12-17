package utilities.dispositif;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.intellij.openapi.ui.VerticalFlowLayout;

import utilities.Colors;
import utilities.Fonts;

public class DateAndTime extends JPanel {

    public DateAndTime(){
     
        this.setLayout(new VerticalFlowLayout(VerticalFlowLayout.BOTTOM));
        this.setOpaque(false);

        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        datePanel.setOpaque(false);

        String daty = new SimpleDateFormat("MMMM").format(new Date())+" "+new SimpleDateFormat("dd").format(new Date())+" "+new SimpleDateFormat("yyyy").format(new Date());
        JLabel date = new JLabel(daty);
        date.setFont(new Font(Fonts.textFont,Font.BOLD,15));
        date.setForeground(Colors.backgrounds);

        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        timePanel.setOpaque(false);
        JLabel time = new JLabel();
        time.setFont(new Font(Fonts.textFont,Font.BOLD,50));
        time.setForeground(Colors.backgrounds);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                for(;;){

                    time.setText(LocalTime.now().truncatedTo(ChronoUnit.SECONDS).toString());
                    // Pause pendant une seconde
                    try {Thread.sleep(1000);} catch (InterruptedException e) {}
                }
            }
            
        });
        thread.setDaemon(true);
        thread.start();

        
        timePanel.add(time);
        datePanel.add(date);
        this.add(datePanel);this.add(timePanel);
    }
    
}
