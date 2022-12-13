import com.formdev.flatlaf.FlatLightLaf;

import interfaces.Template;

public class App {

    static Template template;

    public static void main(String[] args) throws Exception {

        FlatLightLaf.setup();
        template = new Template();
        
    }
}
