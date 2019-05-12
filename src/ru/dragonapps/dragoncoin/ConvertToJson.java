package ru.dragonapps.dragoncoin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class ConvertToJson implements Runnable {

    @Override
    public void run() {
        while (true) {
            int score = MainPanel.getScore();
            int automatically = MainPanel.getAutomatically();

            JsonConverter toJson = new JsonConverter(score, automatically);
            Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            String json = GSON.toJson(toJson);

            try (FileWriter writer = new FileWriter("res\\data.json", false)) {
                writer.write(json);
                writer.flush();
                Thread.sleep(1000);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
