package ru.dragonapps.dragoncoin;

import ru.dragonapps.dragoncoin.upgrade.ModelUpgrade;

import javax.swing.*;

import static ru.dragonapps.dragoncoin.Res.RAB_RAB;

class Upgrade {

    JPanel rab() {
        ModelUpgrade rab = new ModelUpgrade();
        rab.setName("Раб");
        rab.setPos(1);
        rab.setPrice(10);
        rab.setSpeed(1);
        rab.setDelay(5);
        rab.setFilename(getClass().getResource(RAB_RAB.getName()));
        rab.init();
        return rab;
    }

    JPanel friend() {
        ModelUpgrade friend = new ModelUpgrade();
        friend.setName("Друг");
        friend.setPos(2);
        friend.setPrice(20);
        friend.setSpeed(5);
        friend.setDelay(4);
        friend.setFilename(getClass().getResource(RAB_RAB.getName()));
        friend.init();
        return friend;
    }

}
