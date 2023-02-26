package Game;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Time extends JTextField{
    private static Timer timer;

    public Time(){
        timer = new Timer(1000, new CountdownTimerListener());
    }

    class CountdownTimerListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            int min, sec;

        }
    }
}
