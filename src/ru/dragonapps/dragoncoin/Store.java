package ru.dragonapps.dragoncoin;

import javax.swing.*;
import java.awt.*;

class Store extends JPanel {

    static JButton close;

    Store() {
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
