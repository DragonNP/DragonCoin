package ru.dragonapps.dragoncoin;

import javax.swing.*;
import java.util.prefs.Preferences;

import static ru.dragonapps.dragoncoin.Res.MAIN_NAMEAPP;

public class Main extends JFrame {

    static Preferences user = Preferences.userRoot();

    private Main() {

        super(MAIN_NAMEAPP.getName());
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);

        MainPanel mainPanel = new MainPanel();
        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
