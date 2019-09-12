package com.company;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class mTimer {
    Timer timer;
    Toolkit toolkit;

    public mTimer() {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(),
                0,        //initial delay
                1*1000);  //subsequent rate
    }

    class RemindTask extends TimerTask {
        int seconds = 0;

        public void run() {
            if (seconds <= 40) {
                toolkit.beep();
                System.out.println(seconds);
                seconds++;
            } else {
                toolkit.beep();
                System.out.println("Time's up! Beep!!!");
                //timer.cancel(); //Not necessary because we call System.exit
                System.exit(0);   //Stops the AWT thread (and everything else)
            }
        }
    }
}
