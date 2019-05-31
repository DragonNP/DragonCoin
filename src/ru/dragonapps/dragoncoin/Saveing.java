package ru.dragonapps.dragoncoin;

import static ru.dragonapps.dragoncoin.Main.user;

public class Saveing implements Runnable {


    @Override
    public void run() {
        while (true) {
            int score = MainPanel.getScore();
            int automatically = MainPanel.getAutomatically();
            user.putInt("DragonCoin_Score", score);
            user.putInt("DragonCoin_Automatically", automatically);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
