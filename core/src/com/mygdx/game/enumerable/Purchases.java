package com.mygdx.game.enumerable;

public enum Purchases {
    // Aqui voce colocará os IDs reais da Play Store (ex: "com.meujogo.noads")
    PURCHASE_ID("google_play_purchase_id");

    private final String value;

    Purchases(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
