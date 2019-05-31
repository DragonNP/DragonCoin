package ru.dragonapps.dragoncoin;

import javax.swing.*;
import java.awt.*;

import static ru.dragonapps.dragoncoin.Res.STORE_CLOSE;

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
        close.setIcon(new ImageIcon(getClass().getResource(STORE_CLOSE.getName())));
        add(close);

//        Rab rab = new Rab();
//        rab.setSize(400, 32+16);
//        rab.setLocation(0, 5+32+5);
//        add(rab);

        Upgrade upgrades = new Upgrade();
        add(upgrades.rab());
        add(upgrades.friend());
    }

}
