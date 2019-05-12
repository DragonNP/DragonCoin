package ru.dragonapps.dragoncoin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonConverter {
    Gson GSON;
    ToJson toJson;

    public void toJson(int score, int automatically){

        toJson = new ToJson(score, automatically);

        GSON = new GsonBuilder().setPrettyPrinting().create();
        String json = GSON.toJson(toJson);
        System.out.println(json);
    }
}

class ToJson{

    int score, automatically;

    public ToJson(int score, int automatically){

        this.score = score;
        this.automatically = automatically;
    }
}
