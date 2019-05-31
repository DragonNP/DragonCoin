package ru.dragonapps.dragoncoin;

import javax.swing.*;
import java.awt.*;

import static ru.dragonapps.dragoncoin.Res.MAINPANEL_CLICK;
import static ru.dragonapps.dragoncoin.Res.MAINPANEL_STORE;
import static ru.dragonapps.dragoncoin.Store.close;
import static ru.dragonapps.dragoncoin.Main.user;

public class MainPanel extends JPanel {

    private static JTextField scoreTextField;
    private static JTextField automaticScore = new JTextField();
    private static int score = 0, automatically = 0;
    private JButton clickButton;
    private JPanel store;

    MainPanel() {
        setBackground(new Color(204, 66, 59));
        setLayout(null);

        new ConvertToObject();

        Runnable Saveing = new Saveing();
        Thread SaveingThread = new Thread(Saveing, "Saveing");

        store = new Store();
        store.setSize(400, 600 / 2 + 50);
        store.setLocation(0, 250);
        store.setVisible(false);

        JButton closeApp = new JButton();
        closeApp.setText("X");
        closeApp.setSize(30, 30);
        closeApp.setLocation(400 - 30, 0);
        closeApp.addActionListener(e -> {
            user.put("DragonCoin_Score", String.valueOf(score));
            user.put("DragonCoin_Automatically", String.valueOf(automatically));
            System.exit(0);
        });
        add(closeApp);

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
        storeButton.setIcon(new ImageIcon(getClass().getResource(MAINPANEL_STORE.getName())));
        storeButton.addActionListener(e -> {
            clickButton.setVisible(false);
            store.setVisible(true);
        });


        automaticScore.setText("Скорость: " + automatically);
        automaticScore.setEditable(false);
        automaticScore.setSize(390, 38);
        automaticScore.setLocation(5, storeButton.getY() + 64 + 5);
        automaticScore.setBackground(new Color(204, 66, 59));
        automaticScore.setBorder(null);
        automaticScore.setFont(new Font("FredokaOne-Regular", Font.PLAIN, 35));
        automaticScore.setHorizontalAlignment(SwingConstants.CENTER);

        clickButton = new JButton();
        clickButton.setBorder(BorderFactory.createEmptyBorder());
        clickButton.setContentAreaFilled(false);
        clickButton.setSize(256, 256); //542
        clickButton.setLocation(72, 600 - 256 - (72 / 2));
        clickButton.setIcon(new ImageIcon(getClass().getResource(MAINPANEL_CLICK.getName())));
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

        SaveingThread.start();
    }

    public static int getScore() {
        return score;
    }

    public static int getAutomatically() {
        return automatically;
    }

    public static void setScore(int score, boolean update) {
        MainPanel.score = score;
        if (update) MainPanel.scoreTextField.setText(String.valueOf(MainPanel.score));
    }

    public static void setAutomatically(int automatically, boolean update) {
        MainPanel.automatically = automatically;
        if (update) MainPanel.automaticScore.setText("Скорость: " + automatically);
    }
}
