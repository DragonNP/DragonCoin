package ru.dragonapps.dragoncoin;

class JsonConverter {

    private int score, automatically;

    JsonConverter(int score, int automatically) {
        this.score = score;
        this.automatically = automatically;
    }

    int getScore() {
        return score;
    }

    int getAutomatically() {
        return automatically;
    }
}