package ru.dragonapps.dragoncoin;

import javax.swing.*;

public class Main extends JFrame {

    private MainPanel mainPanel;

    public Main() {
        super("DragonCoin beta by DragonApps");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new MainPanel();
        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
