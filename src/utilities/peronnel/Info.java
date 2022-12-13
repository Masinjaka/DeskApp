package utilities.peronnel;

import javax.swing.JLabel;

import utilities.Colors;
import utilities.Fonts;
import java.awt.Font;

public class Info extends JLabel{

    private String key,value;

    public Info(String key,String value){
        this.key = key;
        this.value = value;

        this.setText(this.key+": "+this.value);
        this.setFont(new Font(Fonts.textFont,Font.BOLD,15));
        this.setForeground(Colors.text);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    
    
}
