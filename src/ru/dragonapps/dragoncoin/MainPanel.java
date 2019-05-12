package ru.dragonapps.dragoncoin;

import javax.swing.*;
import java.awt.*;

import static ru.dragonapps.dragoncoin.Store.close;

class MainPanel extends JPanel {

    private JTextField scoreTextField;
    private static int score = 0, automatically = 0;
    private JButton clickButton;
    private JPanel store;

    MainPanel() {
        setBackground(new Color(204, 66, 59));
        setLayout(null);

        new ConvertToObject();

        Runnable ConvertToJson = new ConvertToJson();
        Thread converter = new Thread(ConvertToJson, "Converter");

        store = new Store();
        store.setSize(400, 600 / 2 + 50);
        store.setLocation(0, 250);
        store.setVisible(false);

        scoreTextField = new JTextField(String.valueOf(score));
        scoreTextField.setEditable(false);
        scoreTextField.setSize(300, 50);
        scoreTextField.setLocation(50, 30);
        scoreTextField.setBackground(new Color(204, 66, 59));
        scoreTextField.setBorder(null);
        scoreTextField.setFont(new Font("FredokaOne-Regular", Font.PLAIN, 45));
        scoreTextField.setHorizontalAlignment(SwingConstants.CENTER);

        JButton storeButton = new JButton();
        storeButton.setBorder(BorderFactory.createEmptyBorder());
        storeButton.setContentAreaFilled(false);
        storeButton.setSize(64, 64);
        storeButton.setLocation(400 / 2 - 32, scoreTextField.getY() + 50 + 15);
        storeButton.setIcon(new ImageIcon("res\\storeIcon.png"));
        storeButton.addActionListener(e -> {
            clickButton.setVisible(false);
            store.setVisible(true);
        });

        JTextField automaticScore = new JTextField("Скорость: " + automatically);
        automaticScore.setEditable(false);
        automaticScore.setSize(355, 38);
        automaticScore.setLocation(5, storeButton.getY() + 64 + 5);
        automaticScore.setBackground(new Color(204, 66, 59));
        automaticScore.setBorder(null);
        automaticScore.setFont(new Font("FredokaOne-Regular", Font.PLAIN, 35));
        automaticScore.setHorizontalAlignment(SwingConstants.CENTER);

        clickButton = new JButton();
        clickButton.setBorder(BorderFactory.createEmptyBorder());
        clickButton.setContentAreaFilled(false);
        clickButton.setSize(256, 256); //542
        clickButton.setLocation(72, 600 - 256 - 40 - 42);
        clickButton.setIcon(new ImageIcon("res\\clickIcon.png"));
        clickButton.addActionListener(e -> {
            score += 1;
            scoreTextField.setText(String.valueOf(score));
        });

        close.addActionListener(e -> {
            store.setVisible(false);
            clickButton.setVisible(true);
        });

        add(scoreTextField);
        add(storeButton);
        add(automaticScore);
        add(clickButton);
        add(store);

        converter.start();
    }

    static int getScore() {
        return score;
    }

    static int getAutomatically() {
        return automatically;
    }

    static void setScore(int score) {
        MainPanel.score = score;
    }

    static void setAutomatically(int automatically) {
        MainPanel.automatically = automatically;
    }
}
