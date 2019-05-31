package ru.dragonapps.dragoncoin;

public enum Res {

    MAIN_NAMEAPP("DragonCoin v0.8 by DragonApps"),
    MAINPANEL_STORE("/storeIcon.png"),
    MAINPANEL_CLICK("/clickIcon.png"),
    RAB_RAB("/rabIcon.png"),
    STORE_CLOSE("/closeIcon.png");

    private String name;

    Res(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
