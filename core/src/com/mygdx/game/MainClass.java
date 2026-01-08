package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.game.listener.AdsListener;
import com.mygdx.game.screen.splash.SplashScreen;

public class MainClass extends Game {
    private final String deviceId;
    private final String secretKey;
    private final AdsListener adsListener;
    
    // Gerenciador de Assets nativo do libGDX
    public AssetManager assets;

    public MainClass(String deviceId, String secretKey) {
        this(deviceId, secretKey, null);
    }

    public MainClass(String deviceId, String secretKey, AdsListener adsListener) {
        this.deviceId = deviceId;
        this.secretKey = secretKey;
        this.adsListener = adsListener;
    }

    public static MainClass getInstance() {
        return ((MainClass) Gdx.app.getApplicationListener());
    }

    @Override
    public void create() {
        // Log e Input
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.input.setCatchBackKey(true);

        // Inicializa o AssetManager puro
        this.assets = new AssetManager();

        // No libGDX puro, chamamos setScreen diretamente da classe Game
        // Nota: A SplashScreen precisará ser ajustada para o Screen oficial
        setScreen(new SplashScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        if (assets != null) assets.dispose();
    }

    // Métodos auxiliares que você já usava
    public void showAds() {
        if (this.adsListener != null) this.adsListener.showAds();
    }

    public void hideAds() {
        if (this.adsListener != null) this.adsListener.hideAds();
    }

    // Mantendo os getters de dimensão se suas telas precisarem
    public Integer getFullWidth() { return 480; }
    public Integer getFullHeight() { return 800; }
}
