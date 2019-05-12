package ru.dragonapps.dragoncoin;

import javax.swing.*;
import java.awt.*;

public class Store extends JPanel {

    public static JButton close;

    public Store() {
        setBackground(new Color(204, 106, 89));
        setLayout(null);

        close = new JButton();
        close.setBorder(BorderFactory.createEmptyBorder());
        close.setContentAreaFilled(false);
        close.setSize(32, 32);
        close.setLocation(400-32-18, 5);
        close.setIcon(new ImageIcon("closeIcon.png"));
        add(close);
    }
}
