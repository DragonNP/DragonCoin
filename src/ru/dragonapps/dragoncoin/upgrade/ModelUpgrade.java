package ru.dragonapps.dragoncoin.upgrade;

import ru.dragonapps.dragoncoin.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ModelUpgrade extends JPanel {

    private String name;
    private URL filename;
    private int speed, delay, price, pos;
    private Color background = new Color(204, 137, 111);

    public void init() {
        setLayout(null);
        setBackground(background);
        setSize(400, 48);
        if(pos == 1) setLocation(0, 32+10);
        else setLocation(0, 32+5 + (32*pos));

        ImageIcon icon = new ImageIcon(filename);
        JButton iconButton = new JButton();
        iconButton.setIcon(icon);
        iconButton.setSize(32 + 16, 32 + 16);
        iconButton.setLocation(0, 0);
        iconButton.setBorder(BorderFactory.createEmptyBorder());
        iconButton.setContentAreaFilled(false);
        add(iconButton);

        JTextField nameField = new JTextField();
        nameField.setText(name + "  +" + speed + "dc/сек");
        nameField.setSize(400 - 32 - 200, 25);
        nameField.setLocation(35 + 16, 0);
        nameField.setBorder(null);
        nameField.setBackground(background);
        nameField.setFont(new Font("Calibri", Font.BOLD, 24));
        nameField.setEditable(false);
        add(nameField);

        JTextField priceField = new JTextField();
        priceField.setFont(new Font("Calibri", Font.BOLD, 18));
        priceField.setText("Цена: " + price + "dc");
        priceField.setSize(400 - 32 - 200, 23);
        priceField.setLocation(35 + 16, 27);
        priceField.setBorder(null);
        priceField.setBackground(background);
        priceField.setEditable(false);
        add(priceField);

        JButton buy = new JButton();
        buy.setText("Купить");
        buy.setSize(100, 38);
        buy.setLocation(400 - 100 - 18, 5);
        buy.addActionListener(e -> {
            int score = MainPanel.getScore();
            if (score >= price) {
                int getAutomatically = MainPanel.getAutomatically();
                MainPanel.setAutomatically(getAutomatically + speed, true);
                score -= price;
                speed += 1;
                price *= 2;

                nameField.setText(name + "  +" + speed + "dc/сек");
                priceField.setText("Цена: " + price + "dc");
            }
            MainPanel.setScore(score, true);
        });
        add(buy);
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public URL getFilename() {
        return filename;
    }

    public void setFilename(URL filename) {
        this.filename = filename;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public Color getBackground() {
        return background;
    }

    @Override
    public void setBackground(Color background) {
        this.background = background;
    }

}
