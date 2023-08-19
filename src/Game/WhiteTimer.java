package Game;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.ActionEvent;


public class WhiteTimer extends JLabel{

    public static Timer whiteTimer;
    private int wSecond, wMinute;
    private String wddSecond, wddMinute;
    private DecimalFormat dFormat = new DecimalFormat("00");
    private static boolean isDone = false;

    public WhiteTimer(){
        setText("10:00");
        wSecond = 0;
        wMinute = 10;
        whiteCountdownTimer();
        whiteTimer.start();
    }

    public static void main(String[] args){
        new WhiteTimer();
    }

    public void whiteCountdownTimer(){
        whiteTimer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                wSecond--;
                wddSecond = dFormat.format(wSecond);
                wddMinute = dFormat.format(wMinute);
                setText(wddMinute + ":" + wddSecond);

                if (wSecond == -1){
                    wSecond = 59;
                    wMinute--;
                    wddSecond = dFormat.format(wSecond);
                    wddMinute = dFormat.format(wMinute);
                    setText(wddMinute + ":" + wddSecond);
                }

                if (wSecond == 0 && wMinute == 0){
                    isDone = true;
                    whiteTimer.stop();
                }
            }
        });
    }

    public static Timer getWhiteTimer(){
        return whiteTimer;
    }

    public static boolean isWhiteTimerDone(){
        return isDone;
    }
}
