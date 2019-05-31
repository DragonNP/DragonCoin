package ru.dragonapps.dragoncoin;

import static ru.dragonapps.dragoncoin.Main.user;

class ConvertToObject {

    ConvertToObject() {
        int score;
        int automatically;
        score = user.getInt("DragonCoin_Score", 0);
        automatically = user.getInt("DragonCoin_Automatically", 0);

        MainPanel.setScore(score, false);
        MainPanel.setAutomatically(automatically, false);
    }
}
