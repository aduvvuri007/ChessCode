package Game;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.ActionEvent;


public class BlackTimer extends JLabel{

    public static Timer blackTimer;
    private int bSecond, bMinute;
    private String bddSecond, bddMinute;
    private DecimalFormat dFormat = new DecimalFormat();
    private static boolean isDone = false;

    public BlackTimer(){
        setText("10:00");
        bSecond = 0;
        bMinute = 10;
        blackCountdownTimer();
        blackTimer.start();
    }

    public static void main(String[] args){
        new BlackTimer();
    }

    public void blackCountdownTimer(){
        blackTimer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bSecond--;
                bddSecond = dFormat.format(bSecond);
                bddMinute = dFormat.format(bMinute);
                setText(bddMinute + ":" + bddSecond);

                if (bSecond == -1){
                    bSecond = 59;
                    bMinute--;
                    bddSecond = dFormat.format(bSecond);
                    bddMinute = dFormat.format(bMinute);
                    setText(bddMinute + ":" + bddSecond);
                }

                if (bSecond == 0 && bMinute == 0){
                    blackTimer.stop();
                    isDone = true;
                }
            }
        });
    }

    public static Timer getBlackTimer(){
        return blackTimer;
    }

    public static boolean isBlackTimerDone(){
        return isDone;
    }
}