package programerdaritimurkebarat;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;

public class JendelaJiwa extends JFrame {

    public JendelaJiwa(){   
        setTitle("Jendela Jiwaku");
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        try {
            EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    new JendelaJiwa().setVisible(true);
                }
            });
        } catch (InterruptedException ex) {
            //
        } catch (InvocationTargetException ex) {
            //
        }
    }
}
