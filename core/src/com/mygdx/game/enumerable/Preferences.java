package com.mygdx.game.enumerable;

import com.badlogic.gdx.Gdx;

public enum Preferences {
    PURCHASES_RESTORED("purchases-restored", "false");

    private final String key;
    private final String defaultValue;
    private static final String PREF_NAME = "com.mygdx.game.prefs";

    Preferences(String key, String defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    // Atalho para acessar as preferências nativas do libGDX
    private com.badlogic.gdx.Preferences getPrefs() {
        return Gdx.app.getPreferences(PREF_NAME);
    }

    public String getPropertyAsString() {
        return getPrefs().getString(this.key, this.defaultValue);
    }

    public void setPropertyAsString(String value) {
        getPrefs().putString(this.key, value);
        getPrefs().flush(); // Salva as alterações no disco
    }

    public Integer getPropertyAsInteger() {
        return getPrefs().getInteger(this.key, Integer.parseInt(this.defaultValue));
    }

    public void setPropertyAsInteger(Integer value) {
        getPrefs().putInteger(this.key, value);
        getPrefs().flush();
    }

    public Long getPropertyAsLong() {
        return getPrefs().getLong(this.key, Long.parseLong(this.defaultValue));
    }

    public void setPropertyAsLong(Long value) {
        getPrefs().putLong(this.key, value);
        getPrefs().flush();
    }

    public Float getPropertyAsFloat() {
        return getPrefs().getFloat(this.key, Float.parseFloat(this.defaultValue));
    }

    public void setPropertyAsFloat(Float value) {
        getPrefs().putFloat(this.key, value);
        getPrefs().flush();
    }

    public Boolean getPropertyAsBoolean() {
        return getPrefs().getBoolean(this.key, Boolean.parseBoolean(this.defaultValue));
    }

    public void setPropertyAsBoolean(Boolean value) {
        getPrefs().putBoolean(this.key, value);
        getPrefs().flush();
    }
}
