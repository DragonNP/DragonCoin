package ru.dragonapps.dragoncoin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

class ConvertToObject {

    ConvertToObject() {

        StringBuilder output = new StringBuilder();
        Gson GSON = new GsonBuilder().setPrettyPrinting().create();

        try (FileReader reader = new FileReader("data.json")) {
            int c;
            while ((c = reader.read()) != -1) output.append((char) c);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        JsonConverter converter = GSON.fromJson(output.toString(), JsonConverter.class);

        MainPanel.setScore(converter.getScore());
        MainPanel.setAutomatically(converter.getAutomatically());
    }
}
